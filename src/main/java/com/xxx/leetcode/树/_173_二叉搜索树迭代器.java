package 树;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

/**
 * @author shenjingbin
 * @date 2021/11/29
 */
public class _173_二叉搜索树迭代器 {
    private TreeNode cur;
    private Stack<TreeNode> stack;

    public int next() {
        while (Objects.nonNull(cur)) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }

    public boolean hasNext() {
        if (Objects.nonNull(cur) && !stack.isEmpty()) {
            return true;
        }
        return false;
    }
}

