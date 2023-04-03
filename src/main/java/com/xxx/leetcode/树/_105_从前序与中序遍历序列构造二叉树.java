package 树;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.ceil;

/**
 * @author shenjingbin
 * @date 2021/11/21
 */
@SuppressWarnings("unchecked")
public class _105_从前序与中序遍历序列构造二叉树 {
    //中序遍历 inorder = [9,3,15,20,7]
    //后序遍历 postorder = [9,15,7,20,3]
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode(postOrder[postEnd]);
        int index = 0;
        for (int i = inStart; i < inOrder.length; i++) {
            if (inOrder[i] == treeNode.val) {
                index = i;
                break;
            }
        }
        // 左子树的节点个数
        int leftSize = index - inStart;
        // 递归构造左右子树
        treeNode.left = build(inOrder, inStart, index - 1, postOrder, postStart, postStart + leftSize - 1);
        treeNode.right = build(inOrder, index + 1, inEnd, postOrder, postStart + leftSize, postEnd - 1);
        return treeNode;
    }


}
