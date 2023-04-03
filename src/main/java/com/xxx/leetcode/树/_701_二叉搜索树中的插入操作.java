package 树;

import java.util.Objects;

/**
 * @author shenjingbin
 * @date 2021/11/23
 */
public class _701_二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode pre = root;
        TreeNode node = root;
        TreeNode treeNode = new TreeNode(val);
        if (Objects.isNull(pre)) {
            return treeNode;
        }
        while (Objects.nonNull(node)) {
            if (node.val > val) {
                pre = node;
                node = node.left;
            } else if (node.val < val) {
                pre = node;
                node = node.right;
            } else {
                return root;
            }
        }
        if (pre.val > val) {
            pre.left = treeNode;
        } else {
            pre.right = treeNode;
        }
        return root;
    }
}
