package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author shenjingbin
 * @date 2021/11/18
 */
@SuppressWarnings("unused")
public class _94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        while (Objects.nonNull(root)) {
            TreeNode pre;
            if (Objects.nonNull(root.left)) {
                pre = root.left;
                while (Objects.nonNull(pre.right) && pre.right != root) {
                    pre = pre.right;
                }
                if (Objects.isNull(pre.right)) {
                    pre.right = root;
                    root = root.left;
                } else {
                    list.add(root.val);
                    pre.right = null;
                    root = root.right;
                }
            } else {
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    class Recursive {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            return list;
        }

        private void inOrder(TreeNode node, List<Integer> list) {
            if (Objects.isNull(node)) {
                return;
            }
            inOrder(node.left, list);
            list.add(node.val);
            inOrder(node.right, list);
        }
    }

    class Iteration {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || Objects.nonNull(root)) {
                while (Objects.nonNull(root)) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
            return list;
        }

    }
}


