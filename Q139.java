/**
 * 题目描述:
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q139 {
    /**
     * 动态规划
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
        return flag[s.length()]; //返回最后一个值
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


