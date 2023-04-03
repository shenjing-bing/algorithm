package 树;

/**
 * @author shenjingbin
 * @date 2021/11/29
 */
public class _235_二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = p;
        if (p.val >= q.val) {
            p = q;
            q = temp;
        }
        if (root.val >= p.val && root.val <= q.val) {
            return root;
        } else if (root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }
}
