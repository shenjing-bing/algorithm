package 树;

import java.util.Objects;

/**
 * @description: _226_翻转二叉树
 * @date: 2022/1/7 1:09 AM
 * @author: LiuJiaBing
 * @version: 1.0
 */
@SuppressWarnings("unused")
public class _226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


}
