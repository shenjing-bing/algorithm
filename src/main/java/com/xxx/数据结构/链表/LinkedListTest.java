package com.xxx.数据结构.链表;

/**
 * @author shenjingbin
 * @date 2021/9/23
 */

public class LinkedListTest<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> pre;
        Node<E> next;
    }
}
