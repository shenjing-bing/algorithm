package 链表;

//https://leetcode-cn.com/problems/remove-linked-list-elements/
public class _203_移除链表元素 {


    //给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
    public ListNode removeElements(ListNode head, int val) {
        ListNode newFirst = new ListNode(0);
        newFirst.next = head;
        ListNode pre = newFirst;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                //不相等时需要保存当前节点，用于是否删除下一个节点
                pre = head;
            }
            head = head.next;
        }
        return newFirst.next;
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







