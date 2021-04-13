package algorithms;

/**
 * ��Ŀ����
 * ���������������������㽫�����е�һ�����ǵ���һ����ʱ��������������һЩ�ڵ����ص���
 *
 * ����Ҫ�����Ǻϲ�Ϊһ���µĶ��������ϲ��Ĺ�������������ڵ��ص�����ô�����ǵ�ֵ�����Ϊ�ڵ�ϲ������ֵ������ΪNULL �Ľڵ㽫ֱ����Ϊ�¶������Ľڵ㡣
 *
 * ʾ��1:
 *
 * ����:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * ���:
 * �ϲ������:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * ע��:�ϲ�������������ĸ��ڵ㿪ʼ��
 */
public class Q617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) {
            return r1 == null ? r2 : r1;
        }
        r1.val += r2.val;
        r1.left = dfs(r1.left, r2.left);
        r1.right = dfs(r1.right, r2.right);
        return r1;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 3};

        TreeNode root1 = new TreeNode(nums[0]);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);

        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(4);

        root1.right.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(nums[0]);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(4);

        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(4);

        root2.right.right = new TreeNode(3);

        Q617 q = new Q617();
        TreeNode ans = q.mergeTrees(root1, root2);

        System.out.println(ans);
    }
}


