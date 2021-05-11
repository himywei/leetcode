package algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ��Ŀ����
 * ���� n �����ԡ� ��ÿһ�������У���һ���������Ǳȵڶ�������С��
 * <p>
 * ���ڣ����Ƕ���һ�ָ����ϵ�����ҽ��� b < c ʱ������(c, d) �ſ��Ը��� (a, b) ���档������������ʽ������һ����������
 * <p>
 * ����һ�����Լ��ϣ��ҳ��ܹ��γɵ���������ĳ��ȡ��㲻��Ҫ�õ����е����ԣ���������κ�˳��ѡ�����е�һЩ���������졣
 * <p>
 * <p>
 * <p>
 * ʾ����
 * <p>
 * ���룺[[1,2], [2,3], [3,4]]
 * �����2
 * ���ͣ������������ [1,2] -> [3,4]
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * �������Եĸ����� [1, 1000] ��Χ�ڡ�
 */

public class Q646 {
    public int findLongestChain(int[][] pairs) {
        /**
         * ��̬�滮
         * dp[i] λ��0-i��Ӧ���������
         *
         */
        int row = pairs.length;
        int maxLen = 1;
        int[] dp = new int[row];
//        Arrays.sort(pairs, new Comparator<int[]>() { //��ά������������
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) return o1[1] - o2[1];
//                return o1[0] - o2[0];
//            }
//        });
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));

        for (int i = 0; i < row; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};

        Q646 q = new Q646();
        int ans = q.findLongestChain(pairs);
        System.out.println(ans);
    }
}


