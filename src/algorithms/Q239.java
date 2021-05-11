import java.util.LinkedList;

/**
 * ��Ŀ����
 * ����һ���������� nums����һ����СΪk�Ļ������ڴ������������ƶ�����������Ҳࡣ��ֻ���Կ����ڻ��������ڵ� k�����֡���������ÿ��ֻ�����ƶ�һλ��
 * <p>
 * ���ػ��������е����ֵ��
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,3,-1,-3,5,3,6,7], k = 3
 * �����[3,3,5,5,6,7]
 * ���ͣ�
 * �������ڵ�λ��                ���ֵ
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1], k = 1
 * �����[1]
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,-1], k = 1
 * �����[1,-1]
 * ʾ�� 4��
 * <p>
 * ���룺nums = [9,11], k = 2
 * �����[11]
 * ʾ�� 5��
 * <p>
 * ���룺nums = [4,-2], k = 2
 * �����[4]
 */

public class Q239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (queue.isEmpty()) { //����Ϊ��
                queue.addLast(nums[i]);
            } else {
                while (queue.size() >= k) { //���г��ȳ������ڴ�С
                    queue.removeFirst();
                }
                while (!queue.isEmpty() && queue.peekLast() < nums[i]) { //ά���������
                    queue.removeLast();
                }
                queue.addLast(nums[i]);
            }
            if (i >= k - 1) {

                res[++idx] = queue.peekFirst();

            }
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        // int[] nums = {1, -1};
        int[] nums = {1, 3, 1, 2, 0, 5};

        int k = 3;
        Q239 q = new Q239();
        int[] ans = q.maxSlidingWindow(nums, k);
        for (int an : ans) {
            System.out.println(an);
        }
    }
}


