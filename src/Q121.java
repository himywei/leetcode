import java.util.HashSet;
import java.util.Set;


public class Q121 {

  /*  public int maxProfit(int[] prices) {  //����ʱ������
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) { // ����۸���������۸�����
                    continue;
                }
                ans = Math.max(ans, prices[j] - prices[i]);
            }
        }
        return ans;
    }*/

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; //��ͼ۸�
        int maxProfix = 0; //�������
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfix) { // �����ǰ�����Ʊ����������������ǰ����
                maxProfix = prices[i] - minPrice;
            }
        }
        return maxProfix;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Q121 q121 = new Q121();
        int ans = q121.maxProfit(prices);
        System.out.println(ans);
    }
}


