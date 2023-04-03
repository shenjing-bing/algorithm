package 树;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @description: _590_N叉树的后序遍历
 * @date: 2022/1/5 2:02 AM
 * @author: LiuJiaBing
 * @version: 1.0
 */
public class _590_N叉树的后序遍历 {

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (Objects.isNull(root)) {
            return list;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.removeFirst();
            list.addFirst(root.val);
            for (Node child : root.children) {
                stack.push(child);
            }
        }
        return list;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList();
        return recurvePreOrder(root, list);
    }

    private List<Integer> recurvePreOrder(Node node, List<Integer> list) {
        if (Objects.isNull(node)) {
            return list;
        }
        for (Node child : node.children) {
            recurvePreOrder(child, list);
        }
        list.add(node.val);
        return list;
    }
}
