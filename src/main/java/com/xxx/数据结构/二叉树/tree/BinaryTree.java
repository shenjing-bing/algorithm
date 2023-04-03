package com.xxx.数据结构.二叉树.tree;

import com.xxx.数据结构.二叉树.printer.BinaryTreeInfo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * @author shenjingbin
 * @date 2021/11/12
 */
@SuppressWarnings("unused")
public class BinaryTree<E> implements BinaryTreeInfo {
    protected int size;
    protected Node<E> root;

    public int size() {
        return size;
    }

    protected Node<E> nodePredecessor(Node<E> node) {
        if (Objects.isNull(node)) {
            return null;
        }
        node = node.left;
        //从左子树中找前驱,前驱节点在左子树的最右边节点上
        if (Objects.nonNull(node)) {
            while (Objects.nonNull(node.right)) {
                node = node.right;
            }
            return node;
        }
        //从父节点中找前驱，需要在其祖父节点中找到父节点不为空，并且当前节点是父节点右子树，则当前节点的父节点就是前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;

    }

    protected Node<E> nodeSuccessor(Node<E> node) {
        if (Objects.isNull(node)) {
            return null;
        }
        node = node.right;
        //从右子树中找后继
        if (Objects.nonNull(node)) {
            while (Objects.nonNull(node.left)) {
                node = node.left;
            }
            return node;
        }
        //从父节点中找后继
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;

    }

    public int height1() {
        return heightNode(root);
    }

    public int height2() {
        int height = 0;
        if (Objects.isNull(root)) {
            return height;
        }
        Node<E> node = root;
        Deque<Node> deque = new LinkedList<>();
        deque.push(node);
        int ququeSize = 1;// 根节点需要出队1次
        while (!deque.isEmpty()) {
            node = deque.pop();
            ququeSize--;
            if (Objects.nonNull(node.left)) {
                deque.offer(node.left);
            }
            if (Objects.nonNull(node.right)) {
                deque.offer(node.right);
            }
            if (ququeSize == 0) {
                height++;
                ququeSize = deque.size();
            }
        }
        return height;
    }

    public boolean isComplete() {
        if (Objects.isNull(root)) {
            return false;
        }
        Node<E> node = root;
        Deque<Node> deque = new LinkedList<>();
        deque.offer(node);
        Boolean flag = false;
        while (!deque.isEmpty()) {
            node = deque.poll();
            //后续所有节点都是叶子节点
            if (flag && (Objects.nonNull(node.left) || Objects.nonNull(node.right))) {
                return false;
            }
            if (Objects.nonNull(node.left)) {
                deque.offer(node.left);
            } else if (Objects.nonNull(node.right)) {
                return false;

            }
            if (Objects.nonNull(node.right)) {
                deque.offer(node.right);
            } else {
                flag = true;
            }
        }
        return true;
    }

    private int heightNode(Node<E> node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        return 1 + Math.max(heightNode(node.left), heightNode(node.right));
    }

    public void preOrderTraverse(Consumer<E> consumer) {
        if (Objects.isNull(root)) {
            return;
        }
        Node<E> node = root;
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                consumer.accept(node.element);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
    }

    public void inOrderTraverse(Consumer<E> consumer) {
        if (Objects.isNull(root)) {
            return;
        }
        Node<E> node = root;
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            consumer.accept(node.element);
            node = node.right;
        }
    }

    public void postOrderTraverse(Consumer<E> consumer) {
        if (Objects.isNull(root)) {
            return;
        }
        Node<E> node = root;
        Stack<Node> stack = new Stack<>();
        Node<E> pre = null;
        //pre节点的意义是当有又节点时，记录右节点，防止死循环
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null || node.right == pre) {
                consumer.accept(node.element);
                pre = node;
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
    }

    public void levelOrderTraverse(Consumer<E> consumer) {
        if (Objects.isNull(root)) {
            return;
        }
        Node<E> node = root;
        Deque<Node> deque = new LinkedList<>();
        deque.push(node);
        while (!deque.isEmpty()) {
            node = deque.pop();
            consumer.accept(node.element);
            if (Objects.nonNull(node.left)) {
                deque.offer(node.left);
            }
            if (Objects.nonNull(node.right)) {
                deque.offer(node.right);
            }
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node) node).element;
    }

    protected static class Node<E> {
        public Node<E> left;
        public Node<E> right;
        public Node<E> parent;
        public E element;

        public Node(Node<E> parent, E element) {
            this.parent = parent;
            this.element = element;
        }

        public Boolean hasTwoChildren() {
            return Objects.nonNull(left) && Objects.nonNull(right);
        }

        public Boolean isLeaf() {
            return Objects.isNull(left) && Objects.isNull(right);
        }
    }
}
