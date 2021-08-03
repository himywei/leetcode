package algorithms;

/**
 * �����ÿ���±���Ϊһ�����ݣ��� i �����ݶ�Ӧ��һ���Ǹ�������������ֵ?cost[i]���±�� 0 ��ʼ����
 * <p>
 * ÿ��������һ�������㶼Ҫ���Ѷ�Ӧ������ֵ��һ��֧������Ӧ������ֵ����Ϳ���ѡ��������һ�����ݻ������������ݡ�
 * <p>
 * �����ҳ��ﵽ¥�㶥������ͻ��ѡ��ڿ�ʼʱ�������ѡ����±�Ϊ 0 �� 1 ��Ԫ����Ϊ��ʼ���ݡ�
 * <p>
 * ?
 * <p>
 * ʾ��?1��
 * <p>
 * ���룺cost = [10, 15, 20]
 * �����15
 * ���ͣ���ͻ����Ǵ� cost[1] ��ʼ��Ȼ�����������ɵ����ݶ���һ������ 15 ��
 * ?ʾ�� 2��
 * <p>
 * ���룺cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * �����6
 * ���ͣ���ͻ��ѷ�ʽ�Ǵ� cost[0] ��ʼ�����������Щ 1 ������ cost[3] ��һ������ 6 ��
 * ?
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */

public class Q746 {
    /**
     * ��̬�滮
     * dp[i]: ������i��̨������Ҫ����С����
     * ״̬ת�Ʒ��̣�
     * dp[i] = min(dp[i-1],dp[i-2])+cost[i]
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return cost[0];
        }

        int[] dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            int temp = Math.min(dp[0], dp[1]) + cost[i];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        // ���Դӵ����ڶ���Խ����¥����ô��¥�����ѣ�Ҳ������󵽴ﶥ¥��
        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        Q746 q = new Q746();
        int ans = q.minCostClimbingStairs(cost);
        System.out.println(ans);
    }
}


