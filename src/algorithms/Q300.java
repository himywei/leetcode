package algorithms;

/**
 * ��Ŀ����
 * ����һ���������� nums ���ҵ�������ϸ���������еĳ��ȡ�
 * <p>
 * ���������������������������У�ɾ������ɾ���������е�Ԫ�ض����ı�����Ԫ�ص�˳�����磬[3,6,2,7] ������ [0,3,1,6,2,2,7] �������С�
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [10,9,2,5,3,7,101,18]
 * �����4
 * ���ͣ�������������� [2,3,7,101]����˳���Ϊ 4 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [0,1,0,3,2,3]
 * �����4
 * ʾ�� 3��
 * <p>
 * ���룺nums = [7,7,7,7,7,7,7]
 * �����1
 */

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        /**
         * ��̬�滮
         * ״̬ dp[i] : λ��0-i��Ӧ��������г���
         */
        int maxLen = 1;
        int arrLen = nums.length;
        int[] dp = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            int max = 1;//�����0-i��������г���max
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {7, 7, 7};

        Q300 q = new Q300();
        int ans = q.lengthOfLIS(nums);
        System.out.println(ans);
    }
}


