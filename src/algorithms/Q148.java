package algorithms; /**
 * ���������ͷ���head���뽫�䰴 ���� ���в����� ���������� ��
 * <p>
 * ���ף�
 * <p>
 * �������O(nlogn) ʱ�临�ӶȺͳ������ռ临�Ӷ��£����������������
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺head = [4,2,1,3]
 * �����[1,2,3,4]
 * ʾ�� 2��
 * <p>
 * <p>
 * ���룺head = [-1,5,3,4,0]
 * �����[-1,0,3,4,5]
 * ʾ�� 3��
 * <p>
 * ���룺head = []
 * �����[]
 */


import java.util.Arrays;


public class Q148 {

    /**
     * ����
     */
    public ListNode sortList(ListNode head) {
        int[] arr = new int[500001];
        ListNode temp = head;
        int idx = -1;
        while (temp != null) {
            arr[++idx] = temp.val;
            temp = temp.next;
        }
        int[] copyArr = Arrays.copyOf(arr, idx + 1);
        Arrays.sort(copyArr);
        temp = head;
        idx = -1;
        while (temp != null) {
            temp.val = copyArr[++idx];
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 5, 3, 4, 0};
        ListNode head = new ListNode(nums[0]);
        ListNode h1 = head;
        for (int i = 1; i < nums.length; i++) {

            h1.next = new ListNode(nums[i]);
            h1 = h1.next;
        }

        Q148 q141 = new Q148();
        ListNode ans = q141.sortList(head);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}


