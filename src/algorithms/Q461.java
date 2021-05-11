import org.omg.CORBA.INTERNAL;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * ��������֮��ĺ�������ָ�������������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��
 * <p>
 * ������������ x �� y����������֮��ĺ������롣
 * <p>
 * ע�⣺
 * 0 �� x, y < 231.
 * <p>
 * ʾ��:
 * <p>
 * ����: x = 1, y = 4
 * <p>
 * ���: 2
 * <p>
 * ����:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ��   ��
 */

public class Q461 {

    public int hammingDistance(int x, int y) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        while (x != 0 || y != 0) {
            if (x == 0) {
                stack.push(0);
            } else {
                stack.push(x % 2);
            }
            x = x / 2;

            if (y == 0) {
                stack.push(0);
            } else {
                stack.push(y % 2);
            }
            y = y / 2;
        }
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(stack.pop())) {
                ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        Q461 q = new Q461();
        int ans = q.hammingDistance(x, y);
        System.out.println(ans);
    }
}


