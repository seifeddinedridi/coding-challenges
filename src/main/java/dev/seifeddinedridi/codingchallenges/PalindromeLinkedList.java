package dev.seifeddinedridi.codingchallenges;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        // Position fast at the end of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse the linked list starting from slow
        // Slow is now halfway in the linked list
        ListNode previous = null;
        while (slow != null) {
            var next = slow.next;
            slow.next = previous;
            previous = slow;
            slow = next;
        }
        slow = previous;
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
