package dev.seifeddinedridi.codingchallenges;

public class SwapNodeInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = head;
        ListNode current = head.next;
        while (current != null) {
            var temp = current.val;
            current.val = previous.val;
            previous.val = temp;
            previous = current.next;
            current = previous != null ? previous.next : null;
        }
        return head;
    }
}
