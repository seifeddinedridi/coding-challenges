package dev.seifeddinedridi.codingchallenges;

import java.math.BigDecimal;

public class AddTwoLinkedLists {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var current1 = l1;
        var current2 = l2;
        var carryOver = 0;
        ListNode head = null;
        ListNode current = null;
        while (current1 != null || current2 != null) {
            var sum = zeroIfNull(current1) + zeroIfNull(current2) + carryOver;
            carryOver = sum / 10;
            if (head == null) {
                head = new ListNode(sum % 10);
                current = head;
            } else {
                current.next = new ListNode(sum % 10);
                current = current.next;
            }
            current1 = current1 != null ? current1.next : null;
            current2 = current2 != null ? current2.next : null;
        }
        if (carryOver != 0) {
            current.next = new ListNode(carryOver);
        }
        return head;
    }

    private int zeroIfNull(ListNode n) {
        return n == null ? 0 : n.val;
    }

    private BigDecimal convert(ListNode l) {
        var current = l;
        var n = new BigDecimal(0);
        var multiplier = new BigDecimal(1);
        while (current != null) {
            n = n.add(multiplier.multiply(BigDecimal.valueOf(current.val)));
            multiplier = multiplier.multiply(BigDecimal.valueOf(10));
            current = current.next;
        }
        return n;
    }

    private ListNode convert(BigDecimal n) {
        if (n.compareTo(BigDecimal.ZERO) == 0) {
            return new ListNode(0);
        }
        var divider = BigDecimal.valueOf(10);
        ListNode head = null;
        ListNode current = null;
        while (n.compareTo(BigDecimal.ZERO) != 0) {
            var m = n.remainder(divider);
            if (current == null) {
                head = new ListNode(m.intValue());
                current = head;
            } else {
                current.next = new ListNode(m.intValue());
                current = current.next;
            }
            n = n.divideToIntegralValue(divider);
        }
        return head;
    }
}
