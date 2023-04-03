package 树;

import java.util.*;

/**
 * @author shenjingbin
 * @date 2021/11/17
 */
public class _107_二叉树的层序遍历_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        TreeNode node = root;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(node);
        int level = 1;
        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
        List<Integer> integers = new ArrayList<>();
        while (!deque.isEmpty()) {
            node = deque.poll();
            integers.add(node.val);
            level--;
            if (Objects.nonNull(node.left)) {
                deque.offer(node.left);
            }
            if (Objects.nonNull(node.right)) {
                deque.offer(node.right);
            }
            if (Objects.equals(level, 0)) {
                level = deque.size();
                levelOrder.add(0, integers);
                integers = new ArrayList<>();
            }
        }
        return levelOrder;
    }

}
