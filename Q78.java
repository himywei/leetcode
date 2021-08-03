import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ��Ŀ����
 * ����һ����������nums �������е�Ԫ�� ������ͬ �����ظ��������п��ܵ��Ӽ����ݼ�����
 * <p>
 * �⼯ ���� �����ظ����Ӽ�������԰� ����˳�� ���ؽ⼯��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,3]
 * �����[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * ʾ�� 2��
 * <p>
 * ���룺nums = [0]
 * �����[[],[0]]
 */

public class Q78 {

//    /**
//     * �ǵݹ鷽��
//     */
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> list = new ArrayList<>(); //��ʼ�����Ӽ���
//        res.add(list);
//        for (int num : nums) {
//            List<List<Integer>> subSets = new ArrayList<>();//�Ӽ�����
//            for (List<Integer> re : res) {
//                List<Integer> subSet = new ArrayList<>(re); //���������Ӽ�
//                subSet.add(num);//�����Ӽ�
//                subSets.add(subSet);
//            }
//            res.addAll(subSets);
//        }
//        return res;
//    }

    /**
     * �ݹ鷽��
     */
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        backTracking(nums, len, 0);
        return res;
    }

    private void backTracking(int[] nums, int len, int startIndex) {
        res.add(new ArrayList<>(path)); //�ռ����е��Ӽ�
        if (startIndex == len) { //�ݹ�ֹͣ
            return;
        }
        for (int i = startIndex; i < len; i++) {
            path.addLast(nums[i]);
            backTracking(nums, len, i + 1); //�ݹ�
            path.removeLast();//����
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Q78 q = new Q78();
        List<List<Integer>> ans = q.subsets(nums);
        System.out.println(ans);
    }
}


