package 链表;

/**
 * @author shenjingbin
 * @date 2021/10/18
 */
public class _19_删除链表的倒数第N个结点 {
    //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode dumary = new ListNode();
        ListNode first = dumary;
        dumary.next = head;
        while (head != null) {
            head = head.next;
            size++;
        }
        for (int i = 0; i <= size - n; i++) {
            if (i == size - n) {
                first.next = first.next.next;
            } else {
                first = first.next;
            }

        }
        return dumary.next;
    }
    //采用双指针，

    /**
     * 1. 第一个指针从头节点先走n
     * 2. 第二个指针再从虚拟头节点走，等到第一个指针走完时，第二个指针刚好指向当前要删除的节点的前一个元素
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dumary = new ListNode();
        ListNode first = head, second = dumary;
        dumary.next = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dumary.next;
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
