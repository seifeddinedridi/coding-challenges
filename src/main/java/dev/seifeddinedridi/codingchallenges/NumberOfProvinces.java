package dev.seifeddinedridi.codingchallenges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class NumberOfProvinces {

    static class DisjointSetNode {
        int id;
        int priority;
        int parentId;
        DisjointSetNode(int id, int priority, int parentId) {
            this.id = id;
            this.priority = priority;
            this.parentId = parentId;
        }
    }

    static class DisjointSet {
        private final Map<Integer, DisjointSetNode> nodes = new HashMap<>();

        public void add(int id) {
            nodes.put(id, new DisjointSetNode(id, 0, -1));
        }

        public void connect(int id1, int id2) {
            if (id1 == id2) {
                return;
            }
            var parentId1 = findRootId(id1);
            var parentId2 = findRootId(id2);
            if (parentId1 != -1 && parentId2 != -1 && parentId1 != parentId2) {
                var p1 = nodes.get(parentId1);
                var p2 = nodes.get(parentId2);
                if (p1.priority < p2.priority) {
                    var temp = p1;
                    p1 = p2;
                    p2 = temp;
                }
                p1.priority++;
                p2.parentId = p1.id;
            }
        }

        public int findRootId(int id) {
            if (!nodes.containsKey(id)) {
                return -1;
            }
            var node = nodes.get(id);
            if (node.parentId == -1 || node.parentId == node.id) {
                return node.id;
            }
            return findRootId(node.parentId);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        var disjointSet = new DisjointSet();
        for (int i = 0; i < isConnected.length; i++) {
            disjointSet.add(i);
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    disjointSet.connect(i, j);
                }
            }
        }
        var provinces = new HashSet<Integer>();
        for (int i = 0; i < isConnected.length; i++) {
            var id = disjointSet.findRootId(i);
            if (id != -1) {
                provinces.add(id);
            }
        }

        return provinces.size();
    }
}
