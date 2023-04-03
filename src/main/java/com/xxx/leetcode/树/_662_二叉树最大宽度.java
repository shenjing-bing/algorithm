package 树;

import java.math.BigInteger;
import java.util.*;

/**
 * @author shenjingbin
 * @date 2021/11/17
 */
public class _662_二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        TreeNode node = root;
        Deque<TreeNode> deque = new LinkedList<>();
        node.val = 1;
        deque.offer(node);
        int maxWidth = 1;
        int dequeSize = 1;
        while (!deque.isEmpty()) {
            node = deque.poll();
            dequeSize--;
            if (Objects.nonNull(node.left)) {
                deque.offer(node.left);
                node.left.val = node.val * 2;
            }
            if (Objects.nonNull(node.right)) {
                deque.offer(node.right);
                node.right.val = node.val * 2 + 1;
            }
            if (Objects.equals(dequeSize, 0) && !deque.isEmpty()) {
                dequeSize = deque.size();
                maxWidth = Math.max(maxWidth, deque.getLast().val - deque.getFirst().val + 1);
            }
        }
        return maxWidth;
    }
}
