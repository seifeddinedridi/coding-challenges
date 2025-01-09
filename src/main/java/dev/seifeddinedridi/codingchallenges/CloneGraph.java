package dev.seifeddinedridi.codingchallenges;

import java.util.*;

public class CloneGraph {
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        // We need an index of nodes by value
        var nodeMap = new HashMap<Integer, Node>();
        var visited = new HashSet<Integer>();
        var queue = new LinkedList<Node>();
        queue.add(node);
        while (!queue.isEmpty()) {
            var n = queue.poll();
            if (!visited.contains(n.val)) {
                // First time visiting this node
                visited.add(n.val);
                if (!nodeMap.containsKey(n.val)) {
                    nodeMap.put(n.val, new Node(n.val));
                }
                var clone = nodeMap.get(n.val);
                for (var c : n.neighbors) {
                    // Clone the children
                    if (!nodeMap.containsKey(c.val)) {
                        nodeMap.put(c.val, new Node(c.val));
                    }
                    var childClone = nodeMap.get(c.val);
                    clone.neighbors.add(childClone);
                }
                queue.addAll(n.neighbors);
            }
        }
        return nodeMap.containsKey(1) ? nodeMap.get(1) : null;
    }
}