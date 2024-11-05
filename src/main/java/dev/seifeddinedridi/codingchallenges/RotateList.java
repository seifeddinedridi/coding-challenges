package dev.seifeddinedridi.codingchallenges;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        for (int i = 0; i < k % getLength(head); i++) {
            var last2Nodes = findLastTwoNodes(head);
            last2Nodes[1].next = head;
            last2Nodes[0].next = null;
            head = last2Nodes[1];
        }
        return head;
    }

    private int getLength(ListNode head) {
        var current = head;
        var length = 1;
        while (current != null && current.next != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    private ListNode[] findLastTwoNodes(ListNode head) {
        ListNode previous = null;
        var current = head;
        while (current != null && current.next != null) {
            previous = current;
            current = current.next;
        }
        return new ListNode[] {previous, current};
    }
}
