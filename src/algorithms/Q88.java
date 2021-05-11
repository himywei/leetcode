package algorithms;

import java.util.Arrays;

/**
 * ��������������������'nums1 �� nums2�����㽫 nums2 �ϲ���'nums1'�У�ʹ nums1 ��Ϊһ���������顣
 * <p>
 * ��ʼ��'nums1 �� nums2 ��Ԫ�������ֱ�Ϊ'm �� n ������Լ���'nums1 �Ŀռ��С����'m + n�������������㹻�Ŀռ䱣������ nums2 ��Ԫ�ء�
 * <p>
 * '
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * �����[1,2,2,3,5,6]
 * ʾ�� 2��
 * <p>
 * ���룺nums1 = [1], m = 1, nums2 = [], n = 0
 * �����[1]
 */
public class Q88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * ˫ָ������鲢
         * ÿ�δ�num1����Ч�����к�nums2��ѡ��һ�����ֵ�ŵ�nums���
         */
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n == 0) {
            return;
        }
        int tailPointer = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (tailPointer >= 0) {
            if (m >= 0 && n >= 0) {
                if (nums1[m] >= nums2[n]) {
                    nums1[tailPointer] = nums1[m];
                    m--;
                } else if (nums1[m] < nums2[n]) {
                    nums1[tailPointer] = nums2[n];
                    n--;
                }
            } else if (m >= 0) {//m>=0 && n<0
                return;
            } else { //m<0 && n>=0
                nums1[tailPointer] = nums2[n];
                n--;
            }
            tailPointer--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        Q88 q = new Q88();
        q.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}


