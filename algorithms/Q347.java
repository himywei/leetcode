import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        int idx = 0;
        // ͳ������Ƶ��
        for (int num : nums) {
            map.put(num, map.get(num) == null ? 1 : map.get(num) + 1);
        }
        // Map��ֵ������
        Map<Integer, Integer> sorted = map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        // ѡȡtop k
        for (Integer integer : sorted.keySet()) {
            if (idx < k) {
                res[idx++] = integer;
            } else {
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
            System.out.println(an);

        }
    }
}


