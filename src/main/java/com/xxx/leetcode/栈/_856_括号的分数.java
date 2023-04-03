package 栈;

import java.util.Stack;

/**
 * @author shenjingbin
 * @date 2021/10/20
 */
public class _856_括号的分数 {

    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.push(0);
            } else {
                int curr = stack.pop();
                int w = stack.isEmpty() ? 0 : stack.pop();
                stack.push(w + Math.max(1, curr * 2));
            }
        }
        return stack.pop();
    }
}
