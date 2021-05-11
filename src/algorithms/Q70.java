package algorithms;

/**
 * ������������¥�ݡ���Ҫ n������ܵ���¥����
 *
 * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 *
 * ע�⣺���� n ��һ����������
 *
 * ʾ�� 1��
 *
 * ���룺 2
 * ����� 2
 * ���ͣ� �����ַ�����������¥����
 * 1.  1 �� + 1 ��
 * 2.  2 ��
 * ʾ�� 2��
 *
 * ���룺 3
 * ����� 3
 * ���ͣ� �����ַ�����������¥����
 * 1.  1 �� + 1 �� + 1 ��
 * 2.  1 �� + 2 ��
 * 3.  2 �� + 1 ��
 */

public class Q70 {
    /**
     * ��̬�滮
     * ״̬ת�ƹ�ʽ
     *
     *           f(n-1)+f(n-2) n>=2
     * f(n) =    1   n=1
     *           2   n=2
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else if (i > 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        Q70 q = new Q70();
        int ans = q.climbStairs(n);
        System.out.println(ans);
    }
}


