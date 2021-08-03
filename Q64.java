package algorithms; /**
 * 给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q64 {
    /**
     * 动态规划
     * 状态转移方程：dp[i][j] = min{dp[i-1][j],dp[i][j-1]} +grid[i][j]
     * dp数组存的是到达该点所走的最端距离
     */
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) { //出发点
                    dp[i][j] = grid[i][j];
                } else if (i == 0) { //上边界：只能从左往右走
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {//左边界：只能从上往下走
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {//非边界点和出发点：选择从上走或从左走最近的点
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }


    public static void main(String[] args) {
//        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};

        Q64 q = new Q64();
        int ans = q.minPathSum(grid);
        System.out.println(ans);
    }
}


