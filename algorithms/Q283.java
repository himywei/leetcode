/**
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
 * <p>
 * ʾ��:
 * <p>
 * ����: [0,1,0,3,12]
 * ���: [1,3,12,0,0]
 * ˵��:
 * <p>
 * ������ԭ�����ϲ��������ܿ�����������顣
 * �������ٲ���������
 */

public class Q283 {

    public void moveZeroes(int[] nums) {
        if (nums.length == 1 || nums.length == 0) {
            return;
        }
        int i = nums.length - 1, j = nums.length - 1;
        while (i >= 0) {
            while (i >= 0 && nums[i] != 0) { // �Ӻ�Ѱ�ҵ�һ��0
                i--;
            }
            if (i < 0) {
                break;
            }
            for (int k = i; k < j; k++) { // ����i��jǰ��һλ
                nums[k] = nums[k + 1];
            }
            nums[j] = 0;
            i--;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1};
        Q283 q = new Q283();
        q.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");

        }
    }
}


