import java.util.Arrays;

/**
 * ��Ŀ����
 * ������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ�����-1��
 * <p>
 * �������Ϊÿ��Ӳ�ҵ����������޵ġ�
 * <p>
 * <p>
 * <p>
 * ʾ��1��
 * <p>
 * ���룺coins = [1, 2, 5], amount = 11
 * �����3
 * ���ͣ�11 = 5 + 5 + 1
 * ʾ�� 2��
 * <p>
 * ���룺coins = [2], amount = 3
 * �����-1
 * ʾ�� 3��
 * <p>
 * ���룺coins = [1], amount = 0
 * �����0
 * ʾ�� 4��
 * <p>
 * ���룺coins = [1], amount = 1
 * �����1
 * ʾ�� 5��
 * <p>
 * ���룺coins = [1], amount = 2
 * �����2
 * <p>
 */

public class Q322 {
    public int coinChange(int[] coins, int amount) {
        /**
         * ��̬�滮
         * ״̬ת�Ʒ��̣�dp[i] = min{dp[i-c_1],dp[i-c_2],..}+1,����i������i,dp[i]������ɽ��i���ٵ�Ӳ����
         */
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                    System.out.println("dp[" + i + " - " + coin + "]" + "=" + "dp[" + (i - coin) + "]" + "=" + dp[i - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        int amount = 11;
        Q322 q = new Q322();
        int ans = q.coinChange(nums, amount);
        System.out.println(ans);
    }
}


