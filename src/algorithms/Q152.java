package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ����һ���������� nums�������ҳ������г˻��������������飨�������������ٰ���һ�����֣��������ظ�����������Ӧ�ĳ˻���
 * <p>
 * <p>
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [2,3,-2,4]
 * ���: 6
 * ����:������ [2,3] �����˻� 6��
 * ʾ�� 2:
 * <p>
 * ����: [-2,0,-1]
 * ���: 0
 * ����:�������Ϊ 2, ��Ϊ [-2,-1] ���������顣
 */

public class Q152 {


    public int maxProduct(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int idxMax = 1;
        int idxMin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = idxMax;
                idxMax = idxMin;
                idxMin = tmp;
            }
            idxMax = Math.max(idxMax * num, num);
            idxMin = Math.min(idxMin * num, num);
            max = Math.max(max, idxMax);
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, -1};
        Q152 q = new Q152();
        int ans = q.maxProduct(nums);
        System.out.println(ans);
    }
}


