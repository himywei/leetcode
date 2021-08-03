/**
 * ��Ŀ����:
 * �������� nums ���������У������е�ֵ ������ͬ ��
 * <p>
 * �ڴ��ݸ�����֮ǰ��nums ��Ԥ��δ֪��ĳ���±� k��0 <= k < nums.length���Ͻ����� ��ת��ʹ�����Ϊ [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]���±� �� 0 ��ʼ �����������磬 [0,1,2,4,5,6,7] ���±� 3 ������ת����ܱ�Ϊ[4,5,6,7,0,1,2] ��
 * <p>
 * ���� ��ת�� ������ nums ��һ������ target ����� nums �д������Ŀ��ֵ target ���򷵻��������������򷵻�-1��
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [4,5,6,7,0,1,2], target = 0
 * �����4
 * ʾ��2��
 * <p>
 * ���룺nums = [4,5,6,7,0,1,2], target = 3
 * �����-1
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1], target = 0
 * �����-1
 */

import java.util.ArrayList;
import java.util.List;

public class Q33 {


    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) { // nums[mid]������
                if (target >= nums[left] && target < nums[mid]) { // target��nums[mid]���
                    right = mid - 1;
                } else {// target��nums[mid]�ұ�
                    left = mid + 1;
                }
            } else {  // nums[mid]������
                if (target <= nums[right] && target > nums[mid]) { // target��nums[mid]���
                    left = mid + 1;
                } else {// target��nums[mid]�ұ�
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {3, 1};

        int target = 1;
        Q33 q = new Q33();
        int ans = q.search(nums, target);
        System.out.println(ans);
    }
}


