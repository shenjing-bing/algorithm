package 树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author shenjingbin
 * @date 2021/11/21
 */
@SuppressWarnings("unused")
public class _101_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode left = deque.poll();
            TreeNode right = deque.poll();
            if (Objects.isNull(left) && Objects.isNull(right)) {
                continue;
            }
            if (Objects.nonNull(left) || Objects.nonNull(right) || left.val != right.val) {
                return false;
            }
            deque.offer(left.left);
            deque.offer(right.right);
            deque.offer(left.right);
            deque.offer(right.left);
        }
        return true;
    }

    private Boolean compareRightAndLeft(TreeNode left, TreeNode right) {
        if (Objects.isNull(left) && Objects.isNull(right)) {
            return true;
        }
        if (Objects.nonNull(left) && Objects.nonNull(right)) {
            if (Objects.equals(left.val, right.val)) {
                return compareRightAndLeft(left.left, right.right) && compareRightAndLeft(left.right, right.left);
            }
        }
        return false;
    }
}
