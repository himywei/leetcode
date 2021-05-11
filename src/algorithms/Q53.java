/**
 * ��Ŀ����
 * ����һ���������� nums���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [-2,1,-3,4,-1,2,1,-5,4]
 * �����6
 * ���ͣ�����������[4,-1,2,1] �ĺ����Ϊ6 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1]
 * �����1
 * ʾ�� 3��
 * <p>
 * ���룺nums = [0]
 * �����0
 * ʾ�� 4��
 * <p>
 * ���룺nums = [-1]
 * �����-1
 * ʾ�� 5��
 * <p>
 * ���룺nums = [-100000]
 * �����-100000
 */
public class Q53 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                ans = Math.max(temp, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-1, -2};

        Q53 q = new Q53();
        int ans = q.maxSubArray(nums);
        System.out.println(ans);
    }
}


