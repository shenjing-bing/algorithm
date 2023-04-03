package 链表;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/">...</a>
 * 
 * @author shenjingbin
 * @date 2021/9/27
 */

public class _206_反转链表 {

    /**
     * 双指针
     * 
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (head != null) {
            ListNode temp = head.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            head = temp;
        }
        return pre;
    }

    /**
     * 递归的阶梯思路，例如如果传入的是1->2->3->4->5 则先讲5->4然后再将4->null, 新链表5->4->null 1->2->3->4 然后 先讲4->3,然后在将3->null 新链表5->4->3->null
     * 1->2->3 一直递归
     */
    public ListNode reverseList1(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode newNode = reverseList1(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }

    /**
     * 反转列表迭代的方法 先定义一个空节点，遍历当前链表，每次都将遍历出来的元素插入新链表的头部即可 1。
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = null;
        while (head != null) {
            // 临时节点保存正在遍历的链表的下一个元素
            ListNode temp = head.next;
            // 头插法插入新链表
            head.next = newNode;
            // 重新赋值新链表的头
            newNode = head;
            head = temp;
        }
        return newNode;
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
