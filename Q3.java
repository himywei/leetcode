/**
 *��Ŀ����:
 *����һ���ַ����������ҳ����в������ظ��ַ�����Ӵ��ĳ��ȡ�
 *
 * 
 *
 * ʾ��1:
 *
 * ����: s = "abcabcbb"
 * ���: 3 
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 * ʾ�� 2:
 *
 * ����: s = "bbbbb"
 * ���: 1
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
 * ʾ�� 3:
 *
 * ����: s = "pwwkew"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ���"wke"�������䳤��Ϊ 3��
 *     ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke"��һ�������У������Ӵ���
 * ʾ�� 4:
 *
 * ����: s = ""
 * ���: 0
 * 
 */

import java.util.HashSet;
import java.util.Set;

public class Q3 {


    public int lengthOfLongestSubstring(String s) {
        // ��ϣ���ϣ���¼ÿ���ַ��Ƿ���ֹ�
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // ��ָ�룬��ʼֵΪ -1���൱���������ַ�������߽����࣬��û�п�ʼ�ƶ�
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // ��ָ�������ƶ�һ���Ƴ�һ���ַ�
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // ���ϵ��ƶ���ָ��
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // �� i �� rk ���ַ���һ�����������ظ��ַ��Ӵ�
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "bbbbb";
        Q3 q = new Q3();
        Integer len = q.lengthOfLongestSubstring(str);
        System.out.println(len);
    }
}


