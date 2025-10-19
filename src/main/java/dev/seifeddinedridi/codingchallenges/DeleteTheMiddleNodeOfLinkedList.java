package dev.seifeddinedridi.codingchallenges;

public class DeleteTheMiddleNodeOfLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        var nodeCount = 0;
        var current = head;
        while (current != null) {
            nodeCount++;
            current = current.next;
        }
        if (nodeCount <= 1) {
            return null;
        }
        var nodeIndex = 0;
        var targetNodeIndex = nodeCount / 2;
        ListNode previous = null;
        current = head;
        while (current != null) {
            if (nodeIndex == targetNodeIndex) {
                previous.next = current.next;
                break;
            }
            nodeIndex++;
            previous = current;
            current = current.next;
        }
        return head;
    }
}
