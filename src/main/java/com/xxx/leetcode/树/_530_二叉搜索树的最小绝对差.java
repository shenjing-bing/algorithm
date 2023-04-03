package 树;

import java.util.Objects;
import java.util.Stack;

/**
 * @author shenjingbin
 * @date 2021/11/23
 */
public class _530_二叉搜索树的最小绝对差 {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (Objects.nonNull(root.left)) {
                min = Math.min(min, root.val - root.left.val);


            }

        }
        return min;

    }
}
