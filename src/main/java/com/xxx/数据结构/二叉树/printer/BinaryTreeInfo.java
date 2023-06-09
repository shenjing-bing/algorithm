package com.xxx.数据结构.二叉树.printer;

public interface BinaryTreeInfo {
    /**
     * who is the root node
     */
    Object root();

    /**
     * how to get the left child of the node
     */
    Object left(Object node);

    /**
     * how to get the right child of the node
     */
    Object right(Object node);

    /**
     * how to print the node
     */
    Object string(Object node);
}
