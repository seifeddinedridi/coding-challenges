package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;

public class PartitionLinkedList {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        var pivot = findNode(head, x);
        if (pivot == null) {
            pivot = new ListNode(x);
        }
        ListNode previous = null;
        var current = head;
        var nodesToBeMoved = new ArrayList<ListNode>();
        while (current != null) {
            if (current.val < pivot.val) {
                if (current == head) {
                    // Move the head
                    head = current.next;
                }
                nodesToBeMoved.add(current);
                if (previous != null) {
                    previous.next= current.next;
                }
            } else {
                previous = current;
            }
            current = current.next;
        }
        if (nodesToBeMoved.isEmpty()) {
            return head;
        }
        // Link the found nodes
        current = nodesToBeMoved.getFirst();
        for (var i = 1; i < nodesToBeMoved.size(); i++) {
            current.next = nodesToBeMoved.get(i);
            current = current.next;
        }
        // The last node points to the pivot
        nodesToBeMoved.getLast().next = pivot;
        if (pivot == head) {
            return nodesToBeMoved.getFirst();
        }
        // Find the node just before the pivot
        previous = null;
        current = head;
        while (current != null && current.next != pivot) {
            if (current.val >= pivot.val) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (previous != null) {
            previous.next = nodesToBeMoved.getFirst();
        } else {
            // Pivot is the head
            head = nodesToBeMoved.getFirst();
        }
        nodesToBeMoved.getLast().next = current;
        return head;
    }

    private ListNode findNode(ListNode head, int x) {
        var current = head;
        while (current != null && current.val != x) {
            current = current.next;
        }
        return current;
    }
}
