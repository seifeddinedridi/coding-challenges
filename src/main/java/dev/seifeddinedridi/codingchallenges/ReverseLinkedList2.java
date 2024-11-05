package dev.seifeddinedridi.codingchallenges;

public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        left -= 1;
        right -= 1;
        var leftNode = findNodeAtIndex(head, left);
        var nextNode = findNodeAtIndex(head, right + 1);
        var leftNodeMinusOne = findNodeAtIndex(head, left - 1);

        var currentNode = leftNode;
        var rightNode = findNodeAtIndex(head, right);
        for (int i = 0; i < right - left + 1; i++) {
            var temp = currentNode.next;
            currentNode.next = nextNode;
            nextNode = currentNode;
            currentNode = temp;
        }
        if (left > 0) {
            leftNodeMinusOne.next = nextNode;
            return head;
        }
        return rightNode;
    }

    private ListNode findNodeAtIndex(ListNode head, int index) {
        var i = 0;
        var current = head;
        while (current != null) {
            if (i == index) {
                return current;
            }
            i++;
            current = current.next;
        }
        return null;
    }
}
