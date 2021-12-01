package com.youjian.listnode;

public class LoopNode {

    public static ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    public static void main(String[] args) {

    }
}
