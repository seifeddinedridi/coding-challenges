package dev.seifeddinedridi.codingchallenges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class UniqueIslands {

    private static class DisjointSet {
        // ranking
        private Map<Integer, Integer> ranks;
        private Map<Integer, Integer> parents;

        public DisjointSet(int nodeCount) {
            createDisjointSet(nodeCount);
        }

        int merge(int node1, int node2) {
            // If the parents of node1 and node2 are different, then merge them based on which parents has the highest rank
            // Else do nothing
            int parent1 = findParent(node1);
            int parent2 = findParent(node2);
            if (parent1 != parent2) {
                if (ranks.get(parent1) < ranks.get(parent2)) {
                    var temp = parent1;
                    parent1 = parent2;
                    parent2 = temp;
                }
                // Set parent1 as parent of parent2 and increase the rank of parent1
                parents.put(parent2, parent1);
                ranks.put(parent1, ranks.get(parent1) + ranks.get(parent2) + 1);
            }
            return parent1;
        }

        int findParent(int nodeId) {
            if (!parents.containsKey(nodeId) || parents.get(nodeId) == nodeId) {
                return nodeId;
            }
            return findParent(parents.get(nodeId));
        }

        // create roots
        private void createDisjointSet(int nodeCount) {
            parents = new HashMap<>();
            ranks = new HashMap<>();
            for (int i = 0; i < nodeCount; i++) {
                parents.put(i, i); // self-parented
                ranks.put(i, 0);
            }
        }
    }

    public int numIslands(char[][] grid) {
        var m = grid.length;
        var n = grid[m - 1].length;
        var disjointSet = new DisjointSet(m * n);
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                // Merge nearby cells together
                if (grid[r][c] == '1') {
                    var nodeId = r * n + c;
                    // Below node
                    if (r + 1 < m && grid[r + 1][c] == '1') {
                        disjointSet.merge(nodeId, (r + 1) * n + c);
                    }
                    // Right node
                    if (c + 1 < n && grid[r][c + 1] == '1') {
                        disjointSet.merge(nodeId, r * n + c + 1);
                    }
                    // Left node
                    if (c > 0 && grid[r][c - 1] == '1') {
                        disjointSet.merge(nodeId, r * n + c - 1);
                    }
                    // Top node
                    if (r > 0 && grid[r - 1][c] == '1') {
                        disjointSet.merge(nodeId, (r - 1) * n + c);
                    }
                }
            }
        }
        var islandRoots = new HashSet<Integer>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    var nodeId = r * n + c;
                    islandRoots.add(disjointSet.findParent(nodeId));
                }
            }
        }
        return islandRoots.size();
    }

    public int numIslandsGraph(char[][] grid) {
        var m = grid.length;
        var n = grid[m - 1].length;
        var islandsCount = 0;
        var visitedCells = new boolean[m][n];
        var queue = new LinkedList<Integer>();
        // Find the first cell to visit
        var i = 0;
        var j = 0;
        while (i < m && j < n) {
            while (i < m && j < n && (visitedCells[i][j] || grid[i][j] == '0')) {
                j++;
                if (j == n) {
                    j = 0;
                    i++;
                }
            }
            if (i < m && j < n) {
                queue.add(i * n + j);
                islandsCount++;
            }
            while (!queue.isEmpty()) {
                var nodeId = queue.poll();
                int r = nodeId / n;
                int c = nodeId % n;
                if (grid[r][c] == '1' && !visitedCells[r][c]) {
                    visitedCells[r][c] = true;
                    // Expand the children

                    // Below node
                    if (r + 1 < m && grid[r + 1][c] == '1' && !visitedCells[r + 1][c]) {
                        queue.add((r + 1) * n + c);
                    }
                    // Right node
                    if (c + 1 < n && grid[r][c + 1] == '1' && !visitedCells[r][c + 1]) {
                        queue.add(r * n + c + 1);
                    }
                    // Left node
                    if (c > 0 && grid[r][c - 1] == '1' && !visitedCells[r][c - 1]) {
                        queue.add(r * n + c - 1);
                    }
                    // Top node
                    if (r > 0 && grid[r - 1][c] == '1' && !visitedCells[r - 1][c]) {
                        queue.add((r - 1) * n + c);
                    }
                }
            }
        }
        return islandsCount;
    }
}
