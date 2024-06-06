package 栈;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author shenjingbin
 * @date 2021/10/20
 */
public class _20_有效的括号 {
    public boolean isValid(String s) {
        if (s.length() / 2 != 0) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char aChar : chars) {
            if (map.get(aChar) == null) {
                stack.push(aChar);
            } else {
                if (stack.isEmpty() || !map.get(aChar).equals(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
