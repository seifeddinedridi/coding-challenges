package dev.seifeddinedridi.codingchallenges;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class EvaluateDivisions {
    private static class Node {
        private int id;
        private Set<Node> neighbors;

        Node(int id) {
            this.id = id;
            this.neighbors = new HashSet<>();
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if (equations.size() == 0 || values.length == 0 || queries.size() == 0) {
            return null;
        }
        var nameToId = new HashMap<String, Node>();
        var id = 0;
        for (var eq : equations) {
            if (!nameToId.containsKey(eq.get(0))) {
                nameToId.put(eq.get(0), new Node(id++));
            }
            if (!nameToId.containsKey(eq.get(1))) {
                nameToId.put(eq.get(1), new Node(id++));
            }
            nameToId.get(eq.get(1)).neighbors.add(nameToId.get(eq.get(0)));
            nameToId.get(eq.get(0)).neighbors.add(nameToId.get(eq.get(1)));
        }
        for (var q : queries) {
            if (nameToId.containsKey(q.get(0))
                && nameToId.containsKey(q.get(1))) {
                nameToId.get(q.get(1)).neighbors.add(nameToId.get(q.get(0)));
                nameToId.get(q.get(0)).neighbors.add(nameToId.get(q.get(1)));
            }
        }
        // Create the adjacency list
        var edges = new double[nameToId.size()][nameToId.size()];
        for (var i = 0; i < edges.length; i++) {
            for (var j = 0; j < edges.length; j++) {
                edges[i][j] = -1;
            }
        }
        for (var i = 0; i < equations.size(); i++) {
            var eq = equations.get(i);
            var id1 = nameToId.get(eq.get(0)).id;
            var id2 = nameToId.get(eq.get(1)).id;
            edges[id1][id1] = 1.0;
            edges[id2][id2] = 1.0;
            edges[id1][id2] = values[i];
            edges[id2][id1] = 1.0 / values[i];
        }
        // Solve the queries
        var ans = new double[queries.size()];
        for (var i = 0; i < queries.size(); i++) {
            var q = queries.get(i);
            var var1 = q.get(0);
            var var2 = q.get(1);
            if (!nameToId.containsKey(var1) || !nameToId.containsKey(var2)) {
                ans[i] = -1;
            } else {
                var start = nameToId.get(var1);
                var target = nameToId.get(var2);
                var value = multiplyEdgeValue(start, target, edges, 1.0, new HashSet<>());
                ans[i] = value;
            }
        }
        return ans;
    }

    private double multiplyEdgeValue(Node node, Node target,
        double[][] edges,
        double accumulatedValue, Set<Node> visited) {
        if (node == null || target == null
            || visited.contains(node)) {
            return -1.0;
        }
        if (edges[node.id][target.id] != -1.0) {
            return accumulatedValue * edges[node.id][target.id];
        }
        visited.add(node);
        for (var child : node.neighbors) {
            var edgeValue = edges[node.id][child.id];
            if (child == target && edgeValue != -1.0) {
                return accumulatedValue * edgeValue;
            } else if (edgeValue != -1.0) {
                var r = multiplyEdgeValue(child, target, edges,
                    accumulatedValue * edgeValue, visited);
                if (r != -1.0) {
                    return r;
                }
            }
        }
        return -1.0;
    }
}