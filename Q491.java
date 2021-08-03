package algorithms;

import java.util.*;

/**
 * ��Ŀ����
 * ����һ����������, ����������ҵ����и�����ĵ��������У����������еĳ��������� 2 ��
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺[4, 6, 7, 7]
 * �����[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * ��������ĳ��Ȳ��ᳬ��15��
 * �����е�������Χ��?[-100,100]��
 * ���������п��ܰ����ظ����֣���ȵ�����Ӧ�ñ���Ϊ������һ�������
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/increasing-subsequences
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */

public class Q491 {


    /**
     * �ݹ鷽��
     */
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        backTracking(nums, len, 0);
        return res;
    }

    private void backTracking(int[] nums, int len, int startIndex) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path)); //�ռ����������������Ӽ�
        }
        if (startIndex == len) { //�ݹ�ֹͣ
            return;
        }
        Set<Integer> used = new HashSet<>(); //ͬһ���ڵ���ʹ�õĽڵ�
        for (int i = startIndex; i < len; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast()) { //��֦
                continue;
            }
            if (used.contains(nums[i])) { //ͬһ���ڵ���ӽڵ㲻���ظ�ʹ��
                continue;
            } else {
                used.add(nums[i]);
            }
            path.addLast(nums[i]);
            backTracking(nums, len, i + 1); //�ݹ�
            path.removeLast();//����
        }
    }


    public static void main(String[] args) {
        int[] nums = {4, 7, 6, 7};
        Q491 q = new Q491();
        List<List<Integer>> ans = q.findSubsequences(nums);
        System.out.println(ans);
    }
}


