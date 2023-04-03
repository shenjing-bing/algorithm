package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shenjingbin
 * @date 2021/11/19
 */
public class _145_二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre) {
                list.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }
}
