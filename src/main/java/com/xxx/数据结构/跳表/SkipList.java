package com.xxx.数据结构.跳表;

import java.util.Random;
import java.util.Stack;

/**
 * @description: 跳表
 * @author: liujiabing
 * @create: 2023-03-21 19:53
 **/

public class SkipList<T> {
    // 头节点
    private SkipNode<T> headNode;
    // 当前索引层数
    int highLevel;
    // 用于投掷硬币
    Random random;
    // 最大的层
    final int MAX_LEVEL = 32;

    SkipList() {
        random = new Random();
        headNode = new SkipNode<>(Integer.MIN_VALUE, null);
        highLevel = 0;
    }

    public SkipNode<T> search(int key) {
        SkipNode<T> temp = headNode;
        while (temp != null) {
            if (temp.key == key) {
                return temp;
            } else if (temp.right == null || temp.right.key > key) {
                temp = temp.down;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }

    public void delete(int key) {
        SkipNode<T> temp = headNode;
        while (temp != null) {
            if (temp.right == null) {
                temp = temp.down;
            } else if (temp.right.key == key) {
                temp.right = temp.right.right;
                temp = temp.down;
            } else if (temp.right.key > key)// 需要下降去寻找
            {
                temp = temp.down;
            } else // 右侧比较小向右
            {
                temp = temp.right;
            }
        }
    }

    public void add(SkipNode<T> node) {
        int key = node.key;
        SkipNode<T> findNode = search(key);
        // 如果存在这个key的节点
        if (findNode != null) {
            findNode.value = node.value;
            return;
        }
        // 存储向下的节点，如果但前插入节点需要建立索引,可能在这些节点右侧插入
        Stack<SkipNode<T>> stack = new Stack<>();
        // 查找待插入的节点 找到最底层的哪个节点。
        SkipNode<T> temp = headNode;
        while (temp != null) {
            if (temp.right == null||temp.right.key > key){
                // 将曾经向下的节点记录一下,位了建立索引做准备
                stack.add(temp);
                temp = temp.down;
            } else {
                temp = temp.right;
            }
        }
        // 当前层数，从第一层添加(第一层必须添加，先添加再判断)
        int level = 1;
        // 当需要建立上层索引时，上层新创建的节点的down需要指向下层需要创建的节点
        SkipNode<T> downNode = null;
        while (!stack.isEmpty()) {
            // 在该层插入node,抛出待插入的左侧节点
            temp = stack.pop();
            // 节点需要重新创建
            SkipNode<T> newNode = new SkipNode<>(node.key, node.value);
            //水平方向处理
            newNode.right = temp.right;
            temp.right = newNode;
            //处理竖方向
            newNode.down = downNode;
            // 标记新的节点下次使用
            downNode = newNode;
            // 考虑是否需要向上
            // 已经到达最高级的节点啦
            if (level > MAX_LEVEL){
                break;
            }
            double num = random.nextDouble();// [0-1]随机数
            //// 运气不好结束
            if (num > 0.5){
                break;
            }
            level++;
            // 比当前最大高度要高但是依然在允许范围内 需要改变head节点
            if (level > highLevel) {
                highLevel = level;
                // 需要创建一个新的节点
                SkipNode<T> highHeadNode = new SkipNode<>(Integer.MIN_VALUE, null);
                highHeadNode.down = headNode;
                // 改变head
                headNode = highHeadNode;
                // 新创建的head这一层也需要添加新节点
                stack.add(headNode);
            }
        }

    }

    public void printList() {
        SkipNode<T> teamNode = headNode;
        SkipNode<T> last = teamNode;
        while (last.down != null) {
            last = last.down;
        }
        while (teamNode != null) {
            SkipNode<T> enumNode = teamNode.right;
            SkipNode<T> enumLast = last.right;
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
        SkipList<Integer> list = new SkipList<>();
        for (int i = 1; i < 20; i++) {
            list.add(new SkipNode<>(i, 666));
        }
        list.printList();
        list.delete(4);
        list.delete(8);
        list.printList();
    }

    public static class SkipNode<T> {
        int key;
        T value;
        private SkipNode<T> right;
        private SkipNode<T> down;

        public SkipNode(int key, T value) {
            this.key = key;
            this.value = value;
        }
    }

}