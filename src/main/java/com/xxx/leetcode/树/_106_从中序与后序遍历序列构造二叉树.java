package 树;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author shenjingbin
 * @date 2021/11/19
 */
@SuppressWarnings("uncheck")
public class _106_从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (Objects.equals(inorder[i], postorder[postorder.length - 1])) {
                index = i;
            }
        }
        TreeNode root = new TreeNode(inorder[index]);
        if (index != 0) {
            int[] arr1 = new int[index];
            System.arraycopy(inorder, 0, arr1, 0, index);
            int[] arr2 = new int[index];
            System.arraycopy(postorder, 0, arr2, 0, index);
            System.out.println(1);
            root.left = buildTree(arr1, arr2);
        } else if (index != inorder.length) {
            int[] arr3 = new int[inorder.length - index - 1];
            System.arraycopy(inorder, index + 1, arr3, 0, inorder.length - index - 1);
            int[] arr4 = new int[inorder.length - index - 1];
            System.arraycopy(postorder, index, arr4, 0, inorder.length - index - 1);
            System.out.println(2);
            root.right = buildTree(arr3, arr4);
        }
        return root;
    }
}
