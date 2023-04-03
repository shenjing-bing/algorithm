package 树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @description: _104_二叉树的最大深度
 * @date: 2022/1/4 12:19 AM
 * @author: LiuJiaBing
 * @version: 1.0
 */
public class _104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int height = 1;
        int temp = 1;
        TreeNode node = root;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.offer(node);
        while (!deque.isEmpty()) {
            node = deque.pop();
            temp--;
            if (Objects.nonNull(node.left)) {
                deque.offer(node.left);
            }
            if (Objects.nonNull(node.right)) {
                deque.offer(node.right);
            }
            if (temp == 0 && !deque.isEmpty()) {
                height++;
                temp = deque.size();
            }
        }
        return height;
    }

    public int heightNode(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        return 1 + Math.max(heightNode(node.left), heightNode(node.right));
    }
}
