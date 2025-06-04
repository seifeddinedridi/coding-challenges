package dev.seifeddinedridi.codingchallenges;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return sort(lists, 0, lists.length);
    }

    private ListNode sort(ListNode[] lists, int start, int end) {
        if (end - start <= 1) {
            return lists[start];
        }
        var mid = (start + end) / 2;
        var left = sort(lists, start, mid);
        var right = sort(lists, mid, end);
        // Merge
        ListNode previous = new ListNode(-1);
        ListNode head = previous;
        while (left != null && right != null) {
            if (left.val < right.val) {
                previous.next = left;
                left = left.next;
            } else {
                previous.next = right;
                right = right.next;
            }
            previous = previous.next;
        }
        if (left != null) {
            previous.next = left;
        } else {
            previous.next = right;
        }
        return head.next;
    }

    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        var heap = new PriorityQueue<ListNode>((n1, n2) -> n1.val - n2.val);
        for (var i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                heap.offer(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode head = null;
        ListNode current = null;
        while (!heap.isEmpty()) {
            var node = heap.poll();
            node.next = null;
            if (head == null) {
                head = node;
                current = head;
            } else {
                current.next = node;
                current = node;
            }
        }
        return head;
    }
}
