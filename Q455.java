package algorithms;

import java.util.Arrays;

/**
 * 题目描述:
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值'g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j]'。如果 s[j]'>= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * '
 * 示例'1:
 * <p>
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例'2:
 * <p>
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 */

public class Q455 {
//    /**
//     * 对胃口最小的孩子分配尺寸最小的饼干
//     *
//     * @param g
//     * @param s
//     * @return
//     */
//    public int findContentChildren(int[] g, int[] s) {
//        int ans = 0;
//        int gLength = g.length;
//        int sLength = s.length;
//        Arrays.sort(g);
//        Arrays.sort(s);
//        boolean[] visited = new boolean[sLength];
//        for (int k : g) {
//            for (int j = 0; j < sLength; j++) {
//                if (k <= s[j] && !visited[j]) {
//                    ans += 1;
//                    visited[j] = true;
//                    break;
//                }
//            }
//        }
//        return ans;
//    }

    /**
     * 对胃口最小的孩子分配尺寸最小的饼干
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) { //如果对于孩子i，饼干尺寸满足，则判断下一个孩子
                i++;
                j++;
                ans++;
            } else {//如果对于孩子i，饼干尺寸不满足，换大饼干
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] g = {7, 8, 9, 10};
        int[] s = {5, 6, 7, 8};
        Q455 q = new Q455();
        int res = q.findContentChildren(g, s);
        System.out.println(res);
    }
}



