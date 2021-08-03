package algorithms;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ��Ŀ����
 * �ҳ��������֮��Ϊ?n ��?k?��������ϡ������ֻ������ 1 -?9 ��������������ÿ������в������ظ������֡�
 * <p>
 * ˵����
 * <p>
 * �������ֶ�����������
 * �⼯���ܰ����ظ�����ϡ�?
 * ʾ�� 1:
 * <p>
 * ����: k = 3, n = 7
 * ���: [[1,2,4]]
 * ʾ�� 2:
 * <p>
 * ����: k = 3, n = 9
 * ���: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/combination-sum-iii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */

public class Q216 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1, 0);
        return res;
    }

    void backTracking(int k, int n, int startIndex, int sum) {
        if (sum > n) { //��֦
            return;
        }
        if (path.size() == k && sum == n) { //�ݹ���ֹ����
            res.add(new ArrayList<>(path));
            return;
        }
//        for (int i = startIndex; i <= 9; i++) { //�������
//            path.add(i);
//            sum += i;
//            backTracking(k, n, i + 1, sum); //�ݹ�
//            path.removeLast(); //����
//            sum -= i;
//        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) { //�������+��֦
            path.add(i);
            sum += i;
            backTracking(k, n, i + 1, sum); //�ݹ�
            path.removeLast(); //����
            sum -= i;
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        Q216 q = new Q216();
        List<List<Integer>> ans = q.combinationSum3(k, n);
        System.out.println(ans);
    }
}


