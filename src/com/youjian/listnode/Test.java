package com.youjian.listnode;

public class Test {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node6.next = node3;
//        node5.next = node3;
        ListNode res = IntersectNode.getIntersectNode(node1, node6);
        System.out.println(res.val);
    }
}
