package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/merge-two-sorted-lists

public class MergeTwoSortedLists {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = null;
        ListNode previous = null;
        ListNode cursor = null;
        var cursor1 = list1;
        var cursor2 = list2;
        while (cursor1 != null || cursor2 != null) {
            if (cursor1 != null && (cursor2 == null || cursor1.val < cursor2.val)) {
                cursor = new ListNode(cursor1.val);
                cursor1 = cursor1.next;
            } else {
                cursor = new ListNode(cursor2.val);
                cursor2 = cursor2.next;
            }
            if (previous != null) {
                previous.next = cursor;
            } else {
                ans = cursor;
            }
            previous = cursor;
        }
        return ans;
    }
}