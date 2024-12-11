package dev.seifeddinedridi.codingchallenges;

public class PopulatingNextRightPointersInEachNode2 {
    public Node connect(Node root) {
        depthFirstTraversal(root);
        return root;
    }

    public Node connectExtraSpace(Node root) {
        if (root == null) {
            return null;
        }
        var queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var secondaryQueue = new LinkedList<Node>();
            Node previousNode = null;
            while (!queue.isEmpty()) {
                var node = queue.poll();
                if (previousNode != null) {
                    previousNode.next = node;
                }
                previousNode = node;
                if (node.left != null) {
                    secondaryQueue.add(node.left);
                }
                if (node.right != null) {
                    secondaryQueue.add(node.right);
                }
            }
            queue.addAll(secondaryQueue);
        }
        return root;
    }

    private void depthFirstTraversal(Node parent) {
        if (parent != null) {
            if (parent.right != null) {
                parent.right.next = findNextNodeOnTheSameLevel(parent);
                depthFirstTraversal(parent.right);
            }
            if (parent.left != null) {
                parent.left.next = parent.right != null ? parent.right : findNextNodeOnTheSameLevel(parent);
                depthFirstTraversal(parent.left);
            }
        }
    }

    private Node findNextNodeOnTheSameLevel(Node parent) {
        var nextNode = parent.next;
        while (nextNode != null && nextNode.left == null && nextNode.right == null) {
            nextNode = nextNode.next;
        }
        if (nextNode != null) {
            return nextNode.left != null ? nextNode.left : nextNode.right;
        }
        return null;
    }
}
