package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author shenjingbin
 * @date 2021/11/18
 */
public class _144_二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (Objects.isNull(root)) {
            return list;
        }
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || Objects.nonNull(node)) {
            while (Objects.nonNull(node)) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return list;
    }
}
