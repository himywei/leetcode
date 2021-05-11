package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �� n �����򣬱��Ϊ0 �� n - 1��ÿ�������϶�����һ�����֣���Щ���ִ�������'nums'�С�
 * <p>
 * ����Ҫ����������е����򡣴��Ƶ� i ����������Ի��'nums[i - 1] * nums[i] * nums[i + 1] öӲ�ҡ�'����� i - 1 �� i + 1 �����'i'���ڵ������������š���� i - 1�� i + 1 ����������ı߽磬��ô�͵�����һ������Ϊ 1 ������
 * <p>
 * �����ܻ��Ӳ�ҵ����������
 * <p>
 * '
 * <p>
 * ʾ�� 1��
 * ���룺nums = [3,1,5,8]
 * �����167
 * ���ͣ�
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,5]
 * �����10
 */
public class Q312 {

    public int maxCoins(int[] nums) {
        /**
         * ÿ�δ�ֵ��С������
         * visited��ʾ�����Ƿ񱻴���
         */
        int len = nums.length;
        boolean[] visited = new boolean[len];
        int num = 0;
        int ans = 0;
        while (num < len) {

            //Ѱ��δ����������Сֵ��������
            int minVal = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int i = 0; i < len; i++) {
                if (minVal > nums[i] && !visited[i]) {
                    minVal = nums[i];
                    minIdx = i;
                }
            }
            visited[minIdx] = true; //�������

            int leftIdx = minIdx;//������û�б����Ƶ�����
            while (visited[leftIdx]) {
                leftIdx--;
                if (leftIdx < 0) {
                    break;
                }
            }

            int rightIdx = minIdx;//������û�б����Ƶ�����
            while (visited[rightIdx]) {
                rightIdx++;
                if (rightIdx >= len) {
                    break;
                }
            }

            if (leftIdx < 0) {
                if (rightIdx >= len) {
                    ans += nums[minIdx];
                } else {
                    ans += nums[minIdx] * nums[rightIdx];
                }
            } else {
                if (rightIdx >= len) {
                    ans += nums[leftIdx] * nums[minIdx];
                } else {
                    ans += nums[leftIdx] * nums[minIdx] * nums[rightIdx];
                }
            }
            System.out.println("leftIdx: " + leftIdx + " minIdx: " + minIdx + " rightIdx: " + rightIdx);
            num += 1;
        }
        System.out.println(num);
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 5, 8};
        Q312 q = new Q312();
        int ans = q.maxCoins(nums);
        System.out.println(ans);
    }
}


