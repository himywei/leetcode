package algorithms;

import algorithms.ListNode;

/**
 * 题目描述
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 如下面的两个链表：
 * <p>
 * <p>
 * <p>
 * 在节点 c1 开始相交。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * <p>
 * 示例2：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * <p>
 * 示例3：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *
 * <p>
 */
public class Q160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2) {
            if (h1 == null) {
                h1 = headB;
            } else {
                h1 = h1.next;

            }
            if (h2 == null) {
                h2 = headA;
            } else {
                h2 = h2.next;
            }
        }
        return h1;
    }


    public static void main(String[] args) {
        int[] nums1 = {4, 1, 8, 4, 5};
        int[] nums2 = {5, 0, 1, 8, 4, 5};

        ListNode l1 = new ListNode(nums1[0]);
        ListNode headA = l1;
        ListNode l2 = new ListNode(nums2[0]);
        ListNode headB = l2;

        for (int i = 1; i < 2; i++) {
            l1.next = new ListNode(nums1[i]);
            l1 = l1.next;
        }
        for (int i = 1; i < 3; i++) {
            l2.next = new ListNode(nums2[i]);
            l2 = l2.next;
        }

        for (int i = 2; i < nums1.length; i++) {
            ListNode temp = new ListNode(nums1[i]);
            l1.next = temp;
            l1 = l1.next;
            l2.next = temp;
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


