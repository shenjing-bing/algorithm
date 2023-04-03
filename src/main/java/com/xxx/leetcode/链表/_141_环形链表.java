package 链表;

/**
 *
 * <a href="https://leetcode.cn/problems/linked-list-cycle/">...</a>

 */
public class _141_环形链表 {

    /**
     * 使用快慢指针来解决链表是否有环的问题
     * 1。首先分析如果有环，有环则一定相遇，可用归纳法证明
     * 2。环的大小为K，链表开头距离环交点的距离为L，快指针速度为2v，则满指针速度为V
     * 3。两个节点在相距环焦点距离s的地方相遇了,假设此时慢在环中行驶了X圈，快指针行驶了Y圈，
     * 4。可得出 L+S+XK = Vt L+S+YK=2Vt
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
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
