package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.List;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        // Create a list with the nodes in it
        var list = new ArrayList<ListNode>();
        var current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }
        return sortList(list, 0, list.size());
    }

    private ListNode sortList(List<ListNode> list, int start, int end) {
        if (end - start <= 1) {
            list.get(start).next = null;
            return list.get(start);
        } else if (end - start == 2) {
            // Swap the two nodes
            if (list.get(start).val > list.get(end - 1).val) {
                var temp = list.get(start);
                list.get(start).next = null;
                list.get(end - 1).next = temp;
                return list.get(end - 1);
            }
            list.get(end - 1).next = null;
            return list.get(start);
        }
        // Split
        var mid = (start + end) / 2;
        var left = sortList(list, start, mid);
        var right = sortList(list, mid, end);
        // Merge
        var currentL = left;
        var currentR = right;
        ListNode head = null;
        ListNode current = null;
        while (currentL != null && currentR != null) {
            if (currentL.val <= currentR.val) {
                if (head == null) {
                    head = currentL;
                    current = head;
                } else {
                    current.next = currentL;
                    current = current.next;
                }
                currentL = currentL.next;
            } else {
                if (head == null) {
                    head = currentR;
                    current = head;
                } else {
                    current.next = currentR;
                    current = current.next;
                }
                currentR = currentR.next;
            }
        }
        var leftover = currentR != null ? currentR : currentL;
        while (leftover != null) {
            current.next = leftover;
            current = current.next;
            leftover = leftover.next;
        }
        return head;
    }
}