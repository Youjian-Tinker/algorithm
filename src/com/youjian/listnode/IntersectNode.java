package com.youjian.listnode;

public class IntersectNode {

    public static ListNode getIntersectNode(ListNode head1, ListNode head2) {
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
}
