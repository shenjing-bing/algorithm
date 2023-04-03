package com.xxx.数据结构.二叉树.test;

import com.xxx.数据结构.二叉树.printer.BinaryTrees;
import com.xxx.数据结构.二叉树.tree.BST;

/**
 * @author shenjingbin
 * @date 2021/11/14
 */
public class TestBST {
    public static void main(String[] args) {
        int[] arr = {63, 54, 94, 9, 56, 68, 98, 2, 37, 67, 70, 8, 26, 51, 73, 6, 20, 42, 53, 72, 88, 11, 50, 79, 92, 80};
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            bst.add(j);
        }
        System.out.println();
        System.out.println(BinaryTrees.printString(bst));
        bst.remove(73);
        System.out.println(BinaryTrees.printString(bst));
//        bst.invertTree();
//        System.out.println(BinaryTrees.printString(bst));

//        bst.preOrderTraverse((t)-> System.out.print(t+"-"));
//        System.out.println();
//        bst.inOrderTraverse((t)-> System.out.print(t+"-"));
//        System.out.println();
//        bst.postOrderTraverse((t)-> System.out.print(t+"-"));
//        System.out.println();
//        bst.levelOrderTraverse((t)-> System.out.print(t+"-"));
//        System.out.println();
//        System.out.println(bst.height1());
//        System.out.println(bst.height2());
//        System.out.println(bst.isComplete());
    }


}
