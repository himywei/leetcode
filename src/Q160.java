/**
 * ��Ŀ����
 * ��дһ�������ҵ������������ཻ����ʼ�ڵ㡣
 * <p>
 * ���������������
 * <p>
 * <p>
 * <p>
 * �ڽڵ� c1 ��ʼ�ཻ��
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * �����Reference of the node with value = 8
 * ������ͣ��ཻ�ڵ��ֵΪ 8 ��ע�⣬������������ཻ����Ϊ 0�����Ӹ��Եı�ͷ��ʼ�������� A Ϊ [4,1,8,4,5]������ B Ϊ [5,0,1,8,4,5]���� A �У��ཻ�ڵ�ǰ�� 2 ���ڵ㣻�� B �У��ཻ�ڵ�ǰ�� 3 ���ڵ㡣
 *
 * <p>
 * ʾ��2��
 * <p>
 * <p>
 * <p>
 * ���룺intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * �����Reference of the node with value = 2
 * ������ͣ��ཻ�ڵ��ֵΪ 2 ��ע�⣬������������ཻ����Ϊ 0�����Ӹ��Եı�ͷ��ʼ�������� A Ϊ [0,9,1,2,4]������ B Ϊ [3,2,4]���� A �У��ཻ�ڵ�ǰ�� 3 ���ڵ㣻�� B �У��ཻ�ڵ�ǰ�� 1 ���ڵ㡣
 *
 * <p>
 * ʾ��3��
 * <p>
 * <p>
 * <p>
 * ���룺intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * �����null
 * ������ͣ��Ӹ��Եı�ͷ��ʼ�������� A Ϊ [2,6,4]������ B Ϊ [1,5]�����������������ཻ������ intersectVal ����Ϊ 0���� skipA �� skipB ����������ֵ��
 * ���ͣ������������ཻ����˷��� null��
 *
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Q160 {
    // �ڲ���
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        return null;
    }


    public static void main(String[] args) {
        int[] nums1 = {4, 1, 8, 4, 5};
        int[] nums2 = {5, 0, 1, 8, 4, 5};

        ListNode l1 = new ListNode(nums1[0]);
        ListNode headA = l1;
        ListNode l2 = new ListNode(nums2[0]);
        ListNode headB = l2;

        for (int i = 1; i < nums1.length; i++) {
            l1.next = new ListNode(nums1[i]);
            l1 = l1.next;
        }
        for (int i = 1; i < nums2.length; i++) {
            l2.next = new ListNode(nums2[i]);
            l2 = l2.next;
        }

        Q160 q = new Q160();
        ListNode ans = q.getIntersectionNode(headA, headB);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}


