package 树;

import java.util.*;

/**
 * @author shenjingbin
 * @date 2021/11/18
 */
@SuppressWarnings("unchecked")
public class _589_N_叉树的前序遍历 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList();
        return recurvePreOrder(root, list);
    }

    private List<Integer> recurvePreOrder(Node node, List<Integer> list) {
        if (Objects.isNull(node)) {
            return list;
        }
        list.add(node.val);
        for (Node child : node.children) {
            recurvePreOrder(child, list);
        }
        return list;
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList();
        if (Objects.isNull(root)) {
            return list;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pollLast();
            list.add(root.val);
            Collections.reverse(root.children);
            for (Node child : root.children) {
                stack.push(child);
            }
        }
        return list;
    }
}

