package algorithms;

import java.util.*;

/**
 * ��Ŀ����
 * ������������ n �� k������ 1 ... n �����п��ܵ� k ��������ϡ�
 * <p>
 * ʾ��:
 * <p>
 * ����:?n = 4, k = 2
 * ���:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/combinations
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */

public class Q77 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return res;
    }

    void backTracking(int n, int k, int startIndex) {
        if (path.size() == k) { //�ݹ���ֹ����
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) { //�������
            path.add(i);
            backTracking(n, k, i + 1); //�ݹ�
            path.removeLast(); //����
        }
       /* for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) { //��֦
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }*/
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        Q77 q = new Q77();
        List<List<Integer>> ans = q.combine(n, k);
        System.out.println(ans);
    }
}


