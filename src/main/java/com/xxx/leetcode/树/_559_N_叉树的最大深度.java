package 树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author shenjingbin
 * @date 2021/11/18
 */
public class _559_N_叉树的最大深度 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        int height = 0;
        if (Objects.isNull(root)) {
            return height;
        }
        for (Node child : root.children) {
            height = Math.max(height, maxDepth(child));
        }
        return ++height;
    }

}
