package dev.seifeddinedridi.codingchallenges;

public class RemoveDuplicateNodesFromSortedLinkedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode previous = null;
        var current = head;
        while (current != null) {
            // Find out if the current node is a duplicate or not
            var temp = current.next;
            var found = false;
            while (temp != null && temp.val == current.val) {
                temp = temp.next;
                found = true;
            }
            if (found) {
                if (previous != null) {
                    // Skip a node inside the linked list
                    previous.next = temp;
                } else {
                    // The first node in the linked list is a duplicate
                    head = temp;
                }
                current = temp;
            } else {
                previous = current;
                current = current.next;
            }
        }
        return head;
    }
}
