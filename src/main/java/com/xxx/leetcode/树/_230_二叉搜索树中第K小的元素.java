package 树;

import java.util.Objects;
import java.util.Stack;

/**
 * @author shenjingbin
 * @date 2021/11/29
 */
public class _230_二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (Objects.nonNull(root) || !stack.isEmpty()) {
            while (Objects.nonNull(root)) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (Objects.equals(--k, 0)) {
                return root.val;
            }
            root = root.right;
        }
        throw new RuntimeException("no found");
    }
}
