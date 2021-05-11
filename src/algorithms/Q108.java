package algorithms;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * '
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 */

public class Q108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        return dfs(0, len - 1, nums);
    }

    private TreeNode dfs(int lower, int upper, int[] nums) {
        if (lower > upper) {
            return null;
        }
        int center = (lower + upper) / 2;

        TreeNode root = new TreeNode(nums[center]);
        root.left = dfs(lower, center - 1, nums);
        root.right = dfs(center + 1, upper, nums);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Q108 q = new Q108();
        TreeNode ans = q.sortedArrayToBST(nums);
        System.out.println(ans);

    }
}
