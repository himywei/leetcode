package algorithms;

import java.util.HashMap;

/**
 * �� n �����У�����һЩ�˴���������һЩû��������������� a ����� b ֱ���������ҳ��� b ����� c ֱ����������ô���� a ����� c ���������
 * <p>
 * ʡ�� ��һ��ֱ�ӻ��������ĳ��У����ڲ�������û�������ĳ��С�
 * <p>
 * ����һ�� n x n �ľ��� isConnected ������ isConnected[i][j] = 1 ��ʾ�� i �����к͵� j ������ֱ���������� isConnected[i][j] = 0 ��ʾ���߲�ֱ��������
 * <p>
 * ���ؾ����� ʡ�� ��������
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * �����2
 * ʾ�� 2��
 * <p>
 * ���룺isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * �����3
 */
public class Q547 {

    /**
     * ���鼯��Ѱ�����Ƚڵ�
     * ���鼯�ġ���ѯ��������ִ�С�·��ѹ������һ�߲�ѯһ���޸Ľ��ָ���ǲ��鼯����ɫ
     *
     */
    private int find(int x, HashMap<Integer, Integer> hashMap) {
        int root = x;
        while (hashMap.get(root) != null) {
            root = hashMap.get(root);
        }
        //·��ѹ����������Ϊ2
        while (x != root) {
            int original_father = hashMap.get(x);
            hashMap.put(x, root);
            x = original_father;
        }
        return root;
    }

    /**
     * ���鼯���ϲ�
     */
    private void merge(int x, int y, HashMap<Integer, Integer> hashMap, int[] ans) {
        int rootX = find(x, hashMap);
        int rootY = find(y, hashMap);
        if (rootX != rootY) {
            hashMap.put(rootX, rootY);
            ans[0]--;
        }
    }

    /**
     * ���鼯������½ڵ�
     */
    private void add(int x, HashMap<Integer, Integer> hashMap, int[] ans) {
        if (!hashMap.containsKey(x)) {
            hashMap.put(x, null);
            ans[0]++;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        if (row == 1) {
            return 1;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] ans = {0};
        for (int i = 0; i < row; i++) {
            this.add(i, hashMap, ans);
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    this.merge(i, j, hashMap, ans);
                }
            }
        }
        return ans[0];
    }


    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        Q547 q = new Q547();
        int ans = q.findCircleNum(isConnected);
        System.out.println(ans);

    }
}
