package algorithms;

/**
 * ������������¥�ݡ���Ҫ n������ܵ���¥����
 * <p>
 * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 * <p>
 * ע�⣺���� n ��һ����������
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺 2
 * ����� 2
 * ���ͣ� �����ַ�����������¥����
 * 1.  1 �� + 1 ��
 * 2.  2 ��
 * ʾ�� 2��
 * <p>
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
     * dp[i]:������i��¥�ݵķ�����
     * ״̬ת�Ʒ��̣� dp[i] = dp[i-1]+dp[i-2]
     * �߽�������dp[0]=0,dp[1]=1,dp[2]=2
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 3; i <= n; i++) {
            dp[1] = dp[0] + dp[1];
            dp[0] = dp[1] - dp[0];
        }
        return dp[1];
    }

    public static void main(String[] args) {
        int n = 5;
        Q70 q = new Q70();
        int ans = q.climbStairs(n);
        System.out.println(ans);
    }
}


