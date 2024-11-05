package dev.seifeddinedridi.codingchallenges;

import java.util.HashMap;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        Node newHead = null;
        var current = head;
        Node currentNew = null;
        var oldToNew = new HashMap<Node, Node>();
        while (current != null) {
            if (newHead == null) {
                newHead = new Node(current.val);
                newHead.random = current.random;
                currentNew = newHead;
                oldToNew.put(current, currentNew);
            } else {
                currentNew.next = new Node(current.val);
                currentNew.next.random = current.random;
                oldToNew.put(current, currentNew.next);
                currentNew = currentNew.next;
            }
            current = current.next;
        }
        currentNew = newHead;
        while (currentNew != null) {
            if (currentNew.random != null) {
                currentNew.random = oldToNew.get(currentNew.random);
            }
            currentNew = currentNew.next;
        }
        return newHead;
    }
}
