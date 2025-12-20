package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderRouteToMakeAllPathsLeadToCityZero {

    static class Edge {
        int sourceId;
        int targetId;

        Edge(int sourceId, int targetId) {
            this.sourceId = sourceId;
            this.targetId = targetId;
        }
    }

    public int minReorder(int n, int[][] connections) {
        var nodes = new HashMap<Integer, List<Edge>>();
        for (var connection : connections) {
            var edge = new Edge(connection[0], connection[1]);
            if (!nodes.containsKey(connection[0])) {
                nodes.put(connection[0], new ArrayList<>());
            }
            if (!nodes.containsKey(connection[1])) {
                nodes.put(connection[1], new ArrayList<>());
            }
            nodes.get(connection[0]).add(edge);
            nodes.get(connection[1]).add(edge);
        }
        return reachCityZero(nodes, -1, 0);
    }

    private int reachCityZero(Map<Integer, List<Edge>> nodes,
                              int previousNodeId, int nodeId) {
        var edgeReversalCount = 0;
        for (var edge : nodes.get(nodeId)) {
            if (edge.targetId == previousNodeId) {
                continue;
            }
            if (edge.sourceId == nodeId) {
                // Reverse edge
                var temp = edge.sourceId;
                edge.sourceId = edge.targetId;
                edge.targetId = temp;
                edgeReversalCount++;
            }
            edgeReversalCount += reachCityZero(nodes, nodeId, edge.sourceId);
        }
        return edgeReversalCount;
    }
}
