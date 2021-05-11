package algorithms;

import java.util.Arrays;

/**
 * ��Ŀ����
 * �����������֮��Ĳ��ϸ���������͸���֮�佻�棬���������г�Ϊ�ڶ����С���һ���������ڵĻ���������������������������Ԫ�ص�����Ҳ�ǰڶ����С�
 * <p>
 * ���磬[1,7,4,9,2,5] ��һ���ڶ����У���Ϊ��ֵ (6,-3,5,-7,3)������������ֵġ��෴, [1,4,7,2,5]��[1,7,4,5,5] ���ǰڶ����У���һ����������Ϊ����ǰ������ֵ�����������ڶ�����������Ϊ�������һ����ֵΪ�㡣
 * <p>
 * ����һ���������У�������Ϊ�ڶ����е�������еĳ��ȡ� ͨ����ԭʼ������ɾ��һЩ��Ҳ���Բ�ɾ����Ԫ������������У�ʣ�µ�Ԫ�ر�����ԭʼ˳��
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [1,7,4,9,2,5]
 * ���: 6
 * ����: �������о�Ϊ�ڶ����С�
 * ʾ�� 2:
 * <p>
 * ����: [1,17,5,10,13,15,10,5,16,8]
 * ���: 7
 * ����: ������а�����������Ϊ 7 �ڶ����У�����һ����Ϊ[1,17,10,13,10,16,8]��
 * ʾ�� 3:
 * <p>
 * ����: [1,2,3,4,5,6,7,8,9]
 * ���: 2
 * ����:
 * ���ܷ���O(n) ʱ�临�Ӷ���ɴ���?
 */

public class Q376 {
    public int wiggleMaxLength(int[] nums) {
        /**
         * ��̬�滮
         * dp[i] λ��0-i��ڶ�����
         *
         */
        int arrLen = nums.length;
        int maxLen = 0;
        int[] flag = new int[arrLen]; //λ��i��ڶ����ж�Ӧ�ķ���λ
        Arrays.fill(flag, 1);
        int[] dp = new int[arrLen]; //λ��0-i��ڶ����г���
        for (int i = 0; i < arrLen; i++) {
            if (i == 0) { //�߽�������ֻ��һ����
                dp[i] = 1;
                maxLen = dp[i];
                continue;
            }
            if (i == 1) { //�߽�������ֻ��������
                flag[i] = nums[i] - nums[i - 1];
                if (flag[i] != 0) {
                    dp[i] = 2;
                } else {
                    dp[i] = 1;
                }
                maxLen = Math.max(dp[i - 1], dp[i]);
                continue;
            }
            int max = 1;
            for (int j = 0; j < i; j++) {
                flag[i] = nums[i] - nums[j];
                if (flag[i] * flag[j] < 0) {//˵�����
                    if (dp[j] + 1 > max) {
                        max = dp[j] + 1;
                    }
                }
            }
            dp[i] = max;
            maxLen = Math.max(maxLen, dp[i]);
        }
        for (int i : dp) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i : flag) {
            System.out.print(i + "  ");
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 7, 4, 9, 2, 5};
        Q376 q = new Q376();
        int ans = q.wiggleMaxLength(nums);
//        System.out.println(ans);
    }
}


