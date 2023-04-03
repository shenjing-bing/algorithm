package 链表;

/**
 * @author shenjingbin
 * @date 2021/10/20
 */
//给你一个链表数组，每个链表都已经按升序排列。
//请你将所有链表合并到一个升序链表中，返回合并后的链表。
public class _23_合并K个升序链表 {
    //分治算法，两两合并
    public ListNode mergeKLists(ListNode[] lists) {

        return divideListNode(lists, 0, lists.length - 1);
    }

    public ListNode divideListNode(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        return mergeListNode(divideListNode(lists, start, mid), divideListNode(lists, mid + 1, end));
    }

    public ListNode mergeListNode(ListNode l1, ListNode l2) {
        ListNode dummaryHead = new ListNode();
        ListNode first = dummaryHead;
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
        return dummaryHead.next;
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
