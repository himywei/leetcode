import java.util.ArrayList;
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

    /**
     * �ǵݹ鷽��
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(); //��ʼ�����Ӽ���
        res.add(list);
        for (int num : nums) {
            List<List<Integer>> subSets = new ArrayList<>();//�Ӽ�����
            for (List<Integer> re : res) {
                List<Integer> subSet = new ArrayList<>(re); //���������Ӽ�
                subSet.add(num);//�����Ӽ�
                subSets.add(subSet);
            }
            res.addAll(subSets);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Q78 q = new Q78();
        List<List<Integer>> ans = q.subsets(nums);
        System.out.println(ans);
    }
}


