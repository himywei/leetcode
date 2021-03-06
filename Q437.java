package algorithms;
/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 示例：
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * 返回 3。和等于 8 的路径有:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q437 {

    /**
     * 双递归
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        //每一个节点都作为根节点来进行深搜
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        targetSum -= root.val;
        if (targetSum == 0) {
            return 1 + dfs(root.left, targetSum) + dfs(root.right, targetSum);
        } else {
            return dfs(root.left, targetSum) + dfs(root.right, targetSum);
        }
    }

    public static void main(String[] args) {
        int targetSum = 8;
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);


        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);

        Q437 q = new Q437();
        int ans = q.pathSum(root, targetSum);
        System.out.println(ans);

    }
}
