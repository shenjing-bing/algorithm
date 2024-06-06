package com.xxx.数据结构.跳表;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Random;

/**
 * @description: 跳表
 * @author: liujiabing
 * @create: 2023-03-21 19:53
 **/

public class SkipList<K, V> {
    // 头节点
    private SkipNode<K, V> headNode;
    // 当前跳表最大索引层数
    private int highLevel;
    // 用于投掷硬币
    private Random random;
    // 最大的层
    private static final int MAX_LEVEL = 32;
    // 比较器
    private Comparator<K> comparator;

    public SkipList() {
        this(null);
    }

    public SkipList(Comparator<K> comparator) {
        this.random = new Random();
        this.headNode = new SkipNode<>(null, null);
        this.comparator = comparator;
        this.highLevel = 0;
    }

    @SuppressWarnings("unchecked")
    private int compare(K k1, K k2) {
        return comparator != null ? comparator.compare(k1, k2) : ((Comparable<K>)k1).compareTo(k2);
    }

    public SkipNode<K, V> search(K key) {
        SkipNode<K, V> temp = headNode;
        while (temp != null) {
            if (temp.key == key) {
                return temp;
            } else if (temp.right == null || compare(temp.right.key, key) == 1) {
                temp = temp.down;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }

    public void delete(K key) {
        SkipNode<K, V> temp = headNode;
        while (temp != null) {
            if (temp.right == null) {
                temp = temp.down;
            } else if (temp.right.key == key) {
                temp.right = temp.right.right;
                temp = temp.down;
            } else if (compare(temp.right.key, key) == 1) {
                // 需要下降去寻找
                temp = temp.down;
            } else {
                // 右侧比较小向右
                temp = temp.right;
            }
        }
    }

    public void add(SkipNode<K, V> node) {
        K key = node.key;
        SkipNode<K, V> findNode = search(key);
        // 如果存在这个key的节点
        if (findNode != null) {
            findNode.value = node.value;
            return;
        }
        // 存储向下的节点，如果但前插入节点需要建立索引,可能在这些节点右侧插入
        Deque<SkipNode<K, V>> stack = new ArrayDeque<>();
        // 查找待插入的节点 找到最底层的哪个节点。
        SkipNode<K, V> temp = headNode;
        while (temp != null) {
            if (temp.right == null || compare(temp.right.key, key) == 1) {
                // 将曾经向下的节点记录一下,位了建立索引做准备
                stack.push(temp);
                temp = temp.down;
            } else {
                temp = temp.right;
            }
        }
        // 当前层数，从第一层添加(第一层必须添加，先添加再判断)
        int level = 1;
        // 当需要建立上层索引时，上层新创建的节点的down需要指向下层需要创建的节点
        SkipNode<K, V> downNode = null;
        while (!stack.isEmpty()) {
            // 在该层插入node,抛出待插入的左侧节点
            temp = stack.pop();
            // 节点需要重新创建
            SkipNode<K, V> newNode = new SkipNode<>(node.key, node.value);
            // 水平方向处理
            newNode.right = temp.right;
            temp.right = newNode;
            // 处理竖方向
            newNode.down = downNode;
            // 标记新的节点下次使用
            downNode = newNode;
            // 考虑是否需要向上
            // 已经到达最高级的节点啦
            if (level > MAX_LEVEL) {
                break;
            }
            double num = random.nextDouble();// [0-1]随机数
            //// 运气不好结束
            if (num > 0.5) {
                break;
            }
            level++;
            // 比当前最大高度要高但是依然在允许范围内 需要改变head节点
            if (level > highLevel) {
                highLevel = level;
                // 需要创建一个新的节点
                SkipNode<K, V> highHeadNode = new SkipNode<>(null, null);
                highHeadNode.down = headNode;
                // 改变head
                headNode = highHeadNode;
                // 新创建的head这一层也需要添加新节点
                stack.add(headNode);
            }
        }

    }

    public void printList() {
        SkipNode<K, V> teamNode = headNode;
        SkipNode<K, V> last = teamNode;
        while (last.down != null) {
            last = last.down;
        }
        while (teamNode != null) {
            SkipNode<K, V> enumNode = teamNode.right;
            SkipNode<K, V> enumLast = last.right;
            System.out.printf("%-8s", "head->");
            while (enumLast != null && enumNode != null) {
                if (enumLast.key == enumNode.key) {
                    System.out.printf("%-5s", enumLast.key + "->");
                    enumLast = enumLast.right;
                    enumNode = enumNode.right;
                } else {
                    enumLast = enumLast.right;
                    System.out.printf("%-5s", "");
                }

            }
            teamNode = teamNode.down;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SkipList<Integer, Integer> list = new SkipList<>();
        for (int i = 1; i < 20; i++) {
            list.add(new SkipNode<>(i, 666));
        }
        list.printList();
        list.delete(4);
        list.delete(8);
        list.printList();
    }

    private static class SkipNode<K, V> {
        K key;
        V value;
        private SkipNode<K, V> right;
        private SkipNode<K, V> down;

        public SkipNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}