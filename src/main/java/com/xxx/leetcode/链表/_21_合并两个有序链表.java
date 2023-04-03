package 链表;

/**
 * @author shenjingbin
 * @date 2021/10/19
 */
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
public class _21_合并两个有序链表 {
    //1。思路在原链表上操作
    //2。每次都将first的next指向小的链表，然后将小的链表的元素向后移动
    //3。当有空链表出现时，此时只需要将first的next指向空非空链表既可
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummary = new ListNode();
        ListNode first = dummary;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                first.next = l2;
                l2 = l2.next;
            } else {
                first.next = l1;
                l1 = l1.next;
            }
            first = first.next;
        }
        first.next = l1 == null ? l2 : l1;
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
