package 链表;

/**
 * @author shenjingbin
 * @date 2021/10/8
 */
public class _83_删除排序链表中的重复元素 {


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = deleteDuplicates(head.next);
        if (node.val == head.val) {
            head.next = head.next.next;
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode dummary = new ListNode();
        dummary.next = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }

        }
        return dummary.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
