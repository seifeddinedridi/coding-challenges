package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/snakes-and-ladders

import kotlin.Pair;

import java.util.HashSet;
import java.util.LinkedList;

public class SnakesAndLadder {
    public int snakesAndLadders2(int[][] board) {
        var visited = new HashSet<Integer>();
        var queue = new LinkedList<Pair<Integer, Integer>>();
        var currentPos = new Pair<>(1, 0);
        var n = board.length;
        queue.add(currentPos);
        while (!queue.isEmpty()) {
            currentPos = queue.poll();
            for (var i = currentPos.getFirst() + 1; i <= Math.min(currentPos.getFirst() + 6, n * n); i++) {
                // What if there is a ladder here?
                var dest = getDestination(board, i);
                var nextSquare =  dest != -1 ? dest : i;
                if (nextSquare == n * n) {
                    return currentPos.getSecond() + 1;
                }
                if (!visited.contains(nextSquare)) {
                    visited.add(nextSquare);
                    queue.add(new Pair<>(nextSquare, currentPos.getSecond() + 1));
                }
            }
        }
        return -1;
    }

    public int snakesAndLadders(int[][] board) {
        var visited = new HashSet<Integer>();
        var queue = new LinkedList<Integer>();
        var currentPos = 1;
        var n = board.length;
        queue.add(currentPos);
        var steps = 0;

        //[-1,1,1,1]
        //[-1,7,1,1]
        //[16,1,1,1]
        //[-1,1,9,1]

        while (!queue.isEmpty()) {
            // Visit all children at the current level
            var auxQueue = new LinkedList<Integer>();
            while (!queue.isEmpty()) {
                // Visit children of current parent
                var childSquare = queue.poll();
                var destChildSquare = getDestination(board, childSquare);
                // What if the dest was already visited?
                // dest is a child of currentPos
                destChildSquare =  destChildSquare != -1 ? destChildSquare : childSquare;
                // System.out.print("Visiting: " + nextSquare + " | ");
                if (childSquare == n * n || destChildSquare == n * n) {
                    return steps;
                }
                // Expand childSquare (only when it was not visited)
                if (!visited.contains(destChildSquare)) {
                    visited.add(destChildSquare);
                    // Add all the unvisited children of the current node
                    for (var i = destChildSquare + 1; i <= Math.min(destChildSquare + 6, n * n); i++) {
                        auxQueue.add(i);
                    }
                }
            }
            steps++;
            queue.addAll(auxQueue);
        }
        return -1;
    }

    private int getDestination(int [][] board, int currentPos) {
        var n = board.length;
        int r = (currentPos - 1) / n;
        int c = (currentPos - 1) % n;
        if (r % 2 != 0) {
            c = n - 1 - c;
        }
        r = n - 1 - r;
        return board[r][c];
    }
}