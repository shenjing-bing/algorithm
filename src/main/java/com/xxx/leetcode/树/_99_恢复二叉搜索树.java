package 树;

import java.util.*;

/**
 * @author shenjingbin
 * @date 2021/11/28
 */
public class _99_恢复二叉搜索树 {

    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp1 = null;
        TreeNode temp2 = null;
        TreeNode pre = null;
        while (!stack.isEmpty() || Objects.nonNull(root)) {
            while (Objects.nonNull(root)) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (Objects.nonNull(pre) && pre.val > root.val) {
                temp2 = root;
                if (Objects.isNull(temp2)) {
                    temp1 = pre;
                } else {
                    break;
                }
            }
            pre = root;
            root = root.right;
        }
        swap(temp1, temp2);
    }

    public void swap(TreeNode temp1, TreeNode temp2) {
        int temp = temp1.val;
        temp1.val = temp2.val;
        temp2.val = temp;
    }
}
