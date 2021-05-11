package algorithms;

import java.util.*;

/**
 * ����һ������������ equations ��һ��ʵ��ֵ���� values ��Ϊ��֪���������� equations{i} = {Ai, Bi} �� values{i} ��ͬ��ʾ��ʽ Ai / Bi = values{i} ��ÿ�� Ai �� Bi ��һ����ʾ�����������ַ�����
 * <p>
 * ����һЩ������ queries ��ʾ�����⣬���� queries{j} = {Cj, Dj} ��ʾ�� j �����⣬���������֪�����ҳ� Cj / Dj = ? �Ľ����Ϊ�𰸡�
 * <p>
 * ���� ��������Ĵ� ���������ĳ���޷�ȷ���Ĵ𰸣����� -1.0 �������𰸡���������г����˸�������֪������û�г��ֵ��ַ�����Ҳ��Ҫ�� -1.0 �������𰸡�
 * <p>
 * ע�⣺����������Ч�ġ�����Լ�����������в�����ֳ���Ϊ 0 ��������Ҳ������κ�ì�ܵĽ����
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺equations = {{"a","b"},{"b","c"}}, values = {2.0,3.0}, queries = {{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}}
 * �����{6.00000,0.50000,-1.00000,1.00000,-1.00000}
 * ���ͣ�
 * ������a / b = 2.0, b / c = 3.0
 * ���⣺a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * �����{6.0, 0.5, -1.0, 1.0, -1.0 }
 * ʾ�� 2��
 * <p>
 * ���룺equations = {{"a","b"},{"b","c"},{"bc","cd"}}, values = {1.5,2.5,5.0}, queries = {{"a","c"},{"c","b"},{"bc","cd"},{"cd","bc"}}
 * �����{3.75000,0.40000,5.00000,0.20000}
 * ʾ�� 3��
 * <p>
 * ���룺equations = {{"a","b"}}, values = {0.5}, queries = {{"a","b"},{"b","a"},{"a","c"},{"x","y"}}
 * �����{0.50000,2.00000,-1.00000,-1.00000}
 */
public class Q399 {


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // �� 1 ����Ԥ������������ֵ�� id ����ӳ�䣬ʹ�ò��鼯�ĵײ�ʹ������ʵ�֣��������
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // �� 2 ��������ѯ
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind {

        private int[] parent;

        /**
         * ָ��ĸ�����Ȩֵ
         */
        private double[] weight;


        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            // ��ϵʽ���Ƶ�������ο����롹�·���ʾ��ͼ
            weight[rootX] = weight[y] * value / weight[x];
        }

        /**
         * ·��ѹ��
         *
         * @param x
         * @return ������ id
         */
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("a", "c"), Arrays.
                asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        Q399 q = new Q399();
        double[] ans = q.calcEquation(equations, values, queries);
        for (double an : ans) {
            System.out.print(an + " ");
        }

    }
}
