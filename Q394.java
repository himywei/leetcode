package algorithms;

import java.util.Collections;
import java.util.Stack;

/**
 * ����һ������������ַ������������������ַ�����
 * <p>
 * �������Ϊ: k[encoded_string]����ʾ���з������ڲ��� encoded_string �����ظ� k �Ρ�ע�� k ��֤Ϊ��������
 * <p>
 * �������Ϊ�����ַ���������Ч�ģ������ַ�����û�ж���Ŀո�������ķ��������Ƿ��ϸ�ʽҪ��ġ�
 * <p>
 * ���⣬�������Ϊԭʼ���ݲ��������֣����е�����ֻ��ʾ�ظ��Ĵ��� k �����粻�������3a��2[4]�����롣
 * <p>
 *
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "3[a]2[bc]"
 * �����"aaabcbc"
 * ʾ�� 2��
 * <p>
 * ���룺s = "3[a2[c]]"
 * �����"accaccacc"
 * ʾ�� 3��
 * <p>
 * ���룺s = "2[abc]3[cd]ef"
 * �����"abcabccdcdcdef"
 * ʾ�� 4��
 * <p>
 * ���룺s = "abc3[cd]xyz"
 * �����"abccdcdcdxyz"
 */
public class Q394 {

    public String decodeString(String s) {

        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                stack.push(String.valueOf(num));//������ջ
            }
            if (s.charAt(i) != ']') {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    sb.append(new StringBuilder(stack.pop()).reverse()); //��ջʱ��ת
                }
                String reverse = sb.reverse().toString(); //�ַ�����ת
                stack.pop();//��ջ��[��
                stack.push(String.join("", Collections.nCopies(Integer.parseInt(stack.pop()), reverse)));//�ַ�������,��ջ
            }
            i++;

        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(new StringBuilder(stack.pop()).reverse());
        }
        return ans.reverse().toString();

    }


    public static void main(String[] args) {
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        Q394 q = new Q394();
        String ans = q.decodeString(s);
        System.out.println(ans);
    }
}


