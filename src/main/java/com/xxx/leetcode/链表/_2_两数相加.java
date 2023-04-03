package 链表;

/**
 * @author shenjingbin
 * @date 2021/10/13
 */

public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummpary = new ListNode(-1);
        ListNode temp = dummpary;
        int residue = 0;
        while (l1 != null || l2 != null) {
            int first = l1 == null ? 0 : l1.val;
            int second = l2 == null ? 0 : l2.val;
            int sum = first + second + residue;
            int val = sum % 10;
            residue = sum / 10;
            temp.next = new ListNode(val);
            temp = temp.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (residue != 0) {
            temp.next = new ListNode(residue);
        }
        return dummpary.next;
    }

    public static void main(String[] args) {
        A a = new A();
        a.name = "1";
        B b = new B();
        b.name = "2";
        a.b = b;
        b = new B();
        b.name = "3";
        System.out.println(a.b.name);

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

class A {
    public String name;
    public B b;
}

class B {
    public String name;
}
