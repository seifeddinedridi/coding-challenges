package dev.seifeddinedridi.codingchallenges;

public class ReverseLinkedListNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        var currentEnd = head;
        var previousTail = new ListNode(-1, head);
        ListNode newHead = previousTail;
        while (currentEnd != null) {
            count++;
            if (count % k == 0) {
                // Reverse the sublist from previousTail.next until currentEnd (exclusive)
                // And return the last node in the new sublist
                var beginNode = reverseExclusive(previousTail.next, currentEnd.next);
                var lastNode = previousTail.next;
                currentEnd = lastNode.next;
                // Connect the previous sublist to the current one
                previousTail.next = beginNode;
                previousTail = lastNode;
            } else {
                currentEnd = currentEnd.next;
            }
        }
        return newHead.next;
    }

    // Reverse the list and return the head (the start node)
    private ListNode reverseExclusive(ListNode start, ListNode endExcl) {
        var current = start;
        ListNode previous = null;
        while (current != endExcl) {
            var temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        start.next = endExcl;
        return previous;
    }
}
