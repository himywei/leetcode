/**
 * ��Ŀ����:
 * ����һ��δ������������� nums ���ҳ���������������У���Ҫ������Ԫ����ԭ�������������ĳ��ȡ�
 * <p>
 * <p>
 * <p>
 * ���ף��������Ʋ�ʵ��ʱ�临�Ӷ�ΪO(n) �Ľ��������
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [100,4,200,1,3,2]
 * �����4
 * ���ͣ���������������� [1, 2, 3, 4]�����ĳ���Ϊ 4��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [0,3,7,2,5,8,4,6,0,1]
 * �����9
 */

public class Q128 {
    public int longestConsecutive(int[] nums) {
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        Q128 q = new Q128();
        int ans = q.longestConsecutive(nums);
        System.out.print(ans);
    }
}


