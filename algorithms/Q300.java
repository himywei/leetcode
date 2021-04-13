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
        int ans = 1;
        int[] len = new int[nums.length]; //�洢�ӳ�ʼλ�õ���ǰλ�õ������
        for (int i = 0; i < len.length; i++) { //����г�ʼ��Ϊ1
            len[i] = 1;
        }
        /**
         * ��̬�滮����ǰ�����������
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    len[i] = Math.max(len[i], len[j] + 1);
                    if (len[i] > ans) { //�ҵ�ͬʱ��¼���ֵ
                        ans = len[i];
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {7, 7, 7};

        Q300 q = new Q300();
        int ans = q.lengthOfLIS(nums);
        System.out.println(ans);
    }
}


