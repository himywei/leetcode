package algorithms;

import java.util.List;

/**
 * 题目描述:
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */


public class Q2 {
//
//    /**
//     * 方法1：非递归
//     *
//     * @param l1
//     * @param l2
//     * @return
//     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head = null, tail = null;
//        int carry = 0;
//        while (l1 != null || l2 != null || carry != 0) {
//            int val1 = l1 != null ? l1.val : 0;
//            int val2 = l2 != null ? l2.val : 0;
//            int sumVal = (val1 + val2 + carry) % 10;
//            carry = (val1 + val2 + carry) / 10;
//
//            if (head == null) {
//                head = tail = new ListNode(sumVal);
//            } else {
//                tail.next = new ListNode(sumVal);
//                tail = tail.next;
//            }
//            if (l1 != null) l1 = l1.next;
//            if (l2 != null) l2 = l2.next;
//        }
//        return head;
//    }

    /**
     * 方法2：递归
     *
     * @param l1
     * @param l2
     * @return
     */
    int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //两个链表遍历完且没有进位，停止递归
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        //如果其中一个链表节点为空，且没有进位，则返回没有遍历完的链表节点
        if (l1 != null && l2 == null && carry == 0) {
            return l1;
        } else if (l1 == null && l2 != null && carry == 0) {
            return l2;
        }
        //两链表指针位置上的数字加上进位
        int num = ((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry);
        carry = num / 10;
        num = num % 10;
        ListNode node = new ListNode(num);
        //递归算出这个node的next指向
        node.next = addTwoNumbers(l1 != null ? l1.next : null, l2 != null ? l2.next : null);
        return node;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 4};
        ListNode l1 = new ListNode(nums1[0]), l2 = new ListNode(nums2[0]);
        ListNode lh1 = l1, lh2 = l2;
        for (int i = 1; i < nums1.length; i++) {
            l1.next = new ListNode(nums1[i]);
            l1 = l1.next;
        }
        for (int i = 1; i < nums2.length; i++) {
            l2.next = new ListNode(nums2[i]);
            l2 = l2.next;
        }
        Q2 q = new Q2();
        ListNode l = q.addTwoNumbers(lh1, lh2);
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }

    }
}
