package algorithms;
/**
 * ����һ��������������ʼ�뻷�ĵ�һ���ڵ㡣?��������޻����򷵻�?null��
 * <p>
 * Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���ע�⣬pos ���������ڱ�ʶ�����������������Ϊ�������ݵ������С�
 * <p>
 * ˵�����������޸ĸ���������
 * <p>
 * ���ף�
 * <p>
 * ���Ƿ����ʹ�� O(1) �ռ������⣿
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺head = [3,2,0,-4], pos = 1
 * �������������Ϊ 1 ������ڵ�
 * ���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
 * ʾ��?2��
 * <p>
 * <p>
 * <p>
 * ���룺head = [1,2], pos = 0
 * �������������Ϊ 0 ������ڵ�
 * ���ͣ���������һ��������β�����ӵ���һ���ڵ㡣
 * ʾ�� 3��
 * <p>
 * <p>
 * <p>
 * ���룺head = [1], pos = -1
 * ��������� null
 * ���ͣ�������û�л���
 * <p>
 */

import java.util.*;

public class Q142 {

//    /**
//     * ��ϣ��ʽ
//     */
//    public ListNode detectCycle(ListNode head) {
//        List<ListNode> list = new ArrayList<>();
//        while (head != null) {
//            if (!list.contains(head)) {
//                list.add(head);
//            } else {
//                return head;
//            }
//            head = head.next;
//        }
//        return null;
//    }

    /**
     * ˫ָ�뷽ʽ
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode pre = head;
                while (pre != slow) {
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(3);
//        ListNode pre = head;
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(-4);
//        head.next.next.next.next = pre.next;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);


        Q142 q = new Q142();
        ListNode ans = q.detectCycle(head);
        System.out.println(ans);
    }
}


