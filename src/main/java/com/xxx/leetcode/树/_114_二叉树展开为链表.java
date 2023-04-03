package 树;

import java.util.Objects;
import java.util.Stack;

/**
 * @author shenjingbin
 * @date 2021/11/18
 */
@SuppressWarnings("unused")
public class _114_二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        while (Objects.nonNull(root.right)) {
            root = root.right;
        }
        root.right = right;
    }
}
