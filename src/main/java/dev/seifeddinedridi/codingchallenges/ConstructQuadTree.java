package dev.seifeddinedridi.codingchallenges;

public class ConstructQuadTree {
    public QuadTreeNode construct(int[][] grid) {
        if (grid.length == 0 || grid.length != grid[0].length) {
            return null;
        }
        return createQuadTree(grid, 0, grid.length, 0, grid.length);
    }

    private QuadTreeNode createQuadTree(int[][] grid, int xStart, int xEnd, int yStart, int yEnd) {
        // Check for bounds
        if (hasSameValues(grid, xStart, xEnd, yStart, yEnd)) {
            return new QuadTreeNode(grid[yStart][xStart] == 1, true);
        } else {
            // Divide by four
            var node = new QuadTreeNode(false, false);
            var halfLength = (xEnd - xStart) / 2;
            node.topLeft = createQuadTree(grid, xStart, xStart + halfLength, yStart, yStart + halfLength);
            node.topRight = createQuadTree(grid, xStart + halfLength, xEnd, yStart, yStart + halfLength);
            node.bottomLeft = createQuadTree(grid, xStart, xStart + halfLength, yStart + halfLength, yEnd);
            node.bottomRight = createQuadTree(grid, xStart + halfLength, xEnd, yStart + halfLength, yEnd);
            return node;
        }
    }

    private boolean hasSameValues(int[][] grid, int xStart, int xEnd, int yStart, int yEnd) {
        int match = grid[yStart][xStart];
        for (int i = yStart; i < yEnd; i++) {
            for (int j = xStart; j < xEnd; j++) {
                if (match != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
