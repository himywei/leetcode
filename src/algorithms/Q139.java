/**
 * ��Ŀ����:
 * ����һ���ǿ��ַ��� s ��һ�������ǿյ��ʵ��б� wordDict���ж�s �Ƿ���Ա��ո���Ϊһ���������ֵ��г��ֵĵ��ʡ�
 * <p>
 * ˵����
 * <p>
 * ���ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
 * ����Լ����ֵ���û���ظ��ĵ��ʡ�
 * ʾ�� 1��
 * <p>
 * ����: s = "leetcode", wordDict = ["leet", "code"]
 * ���: true
 * ����: ���� true ��Ϊ "leetcode" ���Ա���ֳ� "leet code"��
 * ʾ�� 2��
 * <p>
 * ����: s = "applepenapple", wordDict = ["apple", "pen"]
 * ���: true
 * ����: ���� true ��Ϊ "applepenapple" ���Ա���ֳ� "apple pen apple"��
 * ע��������ظ�ʹ���ֵ��еĵ��ʡ�
 * ʾ�� 3��
 * <p>
 * ����: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * ���: false
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q139 {
    /**
     * ��̬�滮
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (flag[j] && wordDict.contains(s.substring(j, i))) {
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()]; //�������һ��ֵ
    }

    public static void main(String[] args) {
        String s = "catsandog";
        String[] arrStr = {"cats", "dog", "sand", "and", "cat"};
        List<String> wordDict = new ArrayList<String>(Arrays.asList(arrStr));
        Q139 q = new Q139();
        boolean ans = q.wordBreak(s, wordDict);
        System.out.print(ans);
    }
}


