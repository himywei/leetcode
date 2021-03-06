package algorithms;

/**
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */

public class Q70 {
    /**
     * 动态规划
     * dp[i]:爬到第i个楼梯的方法数
     * 状态转移方程： dp[i] = dp[i-1]+dp[i-2]
     * 边界条件：dp[0]=0,dp[1]=1,dp[2]=2
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


