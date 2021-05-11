/**
 * ��Ŀ����:
 * ��һ���� '0' �� '1' ��ɵĶ�ά�����ڣ��ҵ�ֻ���� '1' ����������Σ��������������
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * �����4
 * ʾ�� 2��
 * <p>
 * <p>
 * ���룺matrix = [["0","1"],["1","0"]]
 * �����1
 * ʾ�� 3��
 * <p>
 * ���룺matrix = [["0"]]
 * �����0
 */

import java.util.Arrays;

public class Q221 {
    public int maximalSquare(char[][] matrix) {
        /**
         * ״̬ת�Ʒ���
         * dp(i,j) = min{dp(i-1,j),dp(i,j-1),dp(i-1,j-1)}+1
         * char to int  =>  eg: '5'-'0' = 5
         */
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0) {  //���Ʊ߽�ֵ
                    dp[i][j] = matrix[i][j] - '0';
                    if (dp[i][j] > ans) {
                        ans = dp[i][j];
                    }
                    continue;
                }
                if (matrix[i][j] - '0' == 0) {
                    dp[i][j] = 0;
                } else {
                    int temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(temp, dp[i - 1][j - 1]) + 1;
                    if (dp[i][j] > ans) {
                        ans = dp[i][j];
                    }
                }
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'0', '1'}, {'1', '0'}};
        Q221 q = new Q221();
        int ans = q.maximalSquare(matrix);
        System.out.print(ans);
    }
}


