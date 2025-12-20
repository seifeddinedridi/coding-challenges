package dev.seifeddinedridi.codingchallenges;

public class MaximumTwiSumOfLinkedList {

    public int pairSum(ListNode head) {
        var length = 0;
        var current = head;
        // Compute the list size
        while (current != null) {
            length++;
            current = current.next;
        }

        // Find the beginning of the second half of the list
        current = head;
        length /= 2;
        while (current != null && length > 1) {
            length--;
            current = current.next;
        }

        var second = current.next;
        current.next = null;
        // Reverse the second half othe linked list
        ListNode previous = null;
        current = second;
        while (second != null) {
            var temp = second.next;
            second.next = previous;
            previous = second;
            second = temp;
        }

        // Calculate the max twin sum
        var first = head;
        second = previous;
        var maxSum = Integer.MIN_VALUE;
        while (first != null && second != null) {
            maxSum = Math.max(maxSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        return maxSum;
    }
}
