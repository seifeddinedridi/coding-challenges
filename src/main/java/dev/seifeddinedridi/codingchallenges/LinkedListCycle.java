package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/linked-list-cycle

import java.util.HashSet;

public class LinkedListCycle {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleExtraStorage(ListNode head) {
        var visitedNodes = new HashSet<ListNode>();
        var current = head;
        while (current != null) {
            if (visitedNodes.contains(current)) {
                return true;
            }
            visitedNodes.add(current);
            current = current.next;
        }
        return false;
    }
}