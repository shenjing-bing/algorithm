package 链表;

/**
 * <a href="https://leetcode-cn.com/problems/delete-node-in-a-linked-list/">...</a>
 * 
 * @author shenjingbin
 * @date 2021/9/24
 *
 */
public class _237_删除链表中的节点 {

    /**
     * 思路描述，我们知道要想删除链表中的节点，我们需要知道前一个节点，这里需要 我们删除当前传入的节点，我们可以先讲创建删除入的节点的值赋值为 其后面的节点，然后删除当前节点的问题，就变成了删除当前节点的下一个节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
