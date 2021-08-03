package algorithms;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/**
 * ��Ŀ����
 * ����һ���ǿյ��������飬�������г���Ƶ��ǰk�ߵ�Ԫ�ء�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: nums = [1,1,1,2,2,3], k = 2
 * ���: [1,2]
 * ʾ�� 2:
 * <p>
 * ����: nums = [1], k = 1
 * ���: [1]
 */

public class Q347 {

    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        int idx = 0;
        // ͳ������Ƶ��
        for (int num : nums) {
            map.put(num, map.get(num) == null ? 1 : map.get(num) + 1);
        }
        //����Ͱ���±���Ƶ�Σ�ֵ�Ƕ�ӦƵ�ε�Ԫ�ؼ���
        List<Integer>[] buckets = new ArrayList[len + 1];
        for (int i = 0; i < len + 1; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Integer integer : map.keySet()) {
            buckets[map.get(integer)].add(integer);
        }

        for (int i = len; i >= 0; i--) {
            List<Integer> temp = buckets[i];
            if (temp.isEmpty()) {
                continue;
            }
            for (Integer integer : temp) {
                res[idx++] = integer;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Q347 q = new Q347();
        int[] ans = q.topKFrequent(nums, k);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}


