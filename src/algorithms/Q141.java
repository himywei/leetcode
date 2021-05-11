package algorithms;

/**
 * ��һ�������ַ��� s ���ݸ��������� numRows ���Դ������¡������ҽ���'Z �������С�
 * <p>
 * ���������ַ���Ϊ "PAYPALISHIRING"'����Ϊ 3 ʱ���������£�
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * ֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"PAHNAPLSIIGYIR"��
 * <p>
 * ����ʵ��������ַ�������ָ�������任�ĺ�����
 * <p>
 * string convert(string s, int numRows);
 * '
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "PAYPALISHIRING", numRows = 3
 * �����"PAHNAPLSIIGYIR"
 * ʾ�� 2��
 * ���룺s = "PAYPALISHIRING", numRows = 4
 * �����"PINALSIGYAHRPI"
 * ���ͣ�
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * ʾ�� 3��
 * <p>
 * ���룺s = "A", numRows = 1
 * �����"A"
 */

import java.util.HashSet;
import java.util.Set;


public class Q141 {

//    /**
//     * ����ջ�ķ���
//     * @param head
//     * @return
//     */
//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return false;
//        }
//        Set<ListNode> set = new HashSet<>();
//        while (head.next != null) {
//            if (set.contains(head)) {
//                return true;
//            } else {
//                set.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }

    /**
     * ˫ָ�뷽��
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode lower = head;
        ListNode faster = head;
        while (faster != null && faster.next != null) { //û�л����˳�whileѭ��
            lower = lower.next;
            faster = faster.next.next;
            if (faster == lower) {  //�л�һ����׷��
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = head;
        Q141 q = new Q141();
        boolean ans = q.hasCycle(head);
        System.out.println(ans);
    }
}


