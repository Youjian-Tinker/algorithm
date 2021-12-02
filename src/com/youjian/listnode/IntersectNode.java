package com.youjian.listnode;

public class IntersectNode {

    public static ListNode getNoLoopIntersect(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        ListNode node1 = head1;
        ListNode node2 = head2;
        int len = 0;
        while (node1.next != null) {
            node1 = node1.next;
            len++;
        }

        while (node2.next != null) {
            node2 = node2.next;
            len--;
        }

        if (node1 != node2) {
            return null;
        }

        node1 = len > 0 ? head1 : head2; // long
        node2 = len > 0 ? head2 : head1; // short
        len = Math.abs(len);
        while (len-- > 0) {
            node1 = node1.next;
        }

        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }

    public static ListNode getBothNode(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        ListNode node1 = null;
        ListNode node2 = null;

        if (loop1 == loop2) { // 相交点在环外
            node1 = head1;
            node2 = head2;
            int len = 0;
            while(node1 != loop1) {
                node1 = node1.next;
                len++;
            }
            while (node2 != loop2) {
                node2 = node2.next;
                len--;
            }
            node1 = len > 0 ? head1 : head2;
            node2 = len > 0 ? head2 : head1;
            len = Math.abs(len);
            while (len-- > 0) {
                node1 = node1.next;
            }
            while (node1 != node2) {
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        } else {
            node1 = loop1.next;
            while (node1 != loop1 && node1 != loop2) {
                node1 = node1.next;
            }

            if (node1 == loop1) { // 不相交
                return null;
            }

            return loop1;
        }
    }

    public static ListNode getIntersectNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        ListNode loop1 = LoopNode.getLoopNode(head1);
        ListNode loop2 = LoopNode.getLoopNode(head2);
        if (loop1 != null && loop2 != null) {
            return getBothNode(head1, loop1, head2, loop2);
        }

        if (loop1 == null && loop2 == null) {
            return getNoLoopIntersect(head1, head2);
        }
        return null;
    }
}
