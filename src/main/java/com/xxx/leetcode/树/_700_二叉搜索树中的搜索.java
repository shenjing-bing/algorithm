package 树;

import java.util.Objects;

/**
 * @author shenjingbin
 * @date 2021/11/23
 */
public class _700_二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (Objects.nonNull(root)) {
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
