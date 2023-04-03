package com.xxx.数据结构.二叉树.tree;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author shenjingbin
 * @date 2021/11/14
 */
public class BST<E> extends BinaryTree<E> {
    private Comparator<E> comparator;

    public BST() {}

    public BST(Comparator comparator) {
        this.comparator = comparator;
    }

    private int compare(E e1, E e2) {
        if (Objects.nonNull(comparator)) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable)e1).compareTo(e2);
    }

    public void add(E element) {
        if (Objects.isNull(root)) {
            root = new Node<>(null, element);
            size++;
            return;
        }
        Node<E> node = root;
        int compare = 0;
        Node parent = null;
        while (node != null) {
            parent = node;
            compare = compare(node.element, element);
            if (compare == 1) {
                node = node.left;
            } else if (compare == -1) {
                node = node.right;
            } else {
                return;
            }
        }
        node = new Node<>(parent, element);
        if (compare > 0) {
            parent.left = node;
        } else if (compare < 0) {
            parent.right = node;
        }
        size++;

    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) {
                return node;
            }
            if (cmp > 0) {
                node = node.right;
            } else { // cmp < 0
                node = node.left;
            }
        }
        return null;
    }

    public void remove(E element) {
        Node<E> node = node(element);
        // 要删除的节点是度为2的节点，则其后继节点一定是度为1或0的节点
        if (node.hasTwoChildren()) {
            Node<E> eNode = nodeSuccessor(node);
            // 用其后继节点的值覆盖掉其本身
            node.element = eNode.element;
            // 统一后续的逻辑,
            node = eNode;
        }
        // 删除度为1或者度为0的节点
        Node<E> replace = node.left != null ? node.left : node.right;
        // 删除度为1的节点
        if (Objects.nonNull(replace)) {
            // 更改子节点的parent
            replace.parent = node.parent;
            // 删除的是根节点
            if (node.parent == null) {
                root = replace;
                // 删除的是节点在父节点的左边
            } else if (node.left == replace) {
                node.parent.left = replace;
                // 删除的是节点在父节点的右边
            } else {
                node.parent.right = replace;
            }
            // 删除的是根节点，并且度为0
        } else if (node.parent == null) {
            root = null;
        } else {
            if (node.parent.left == node) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        }
    }

}
