package 树;

/**
 * @description: _123
 * @date: 2022/1/7 1:21 AM
 * @author: LiuJiaBing
 * @version: 1.0
 */

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
