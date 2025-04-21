package dev.seifeddinedridi.codingchallenges;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int maxPoints = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int nbPoints = 2;
                double a = 0.0;
                boolean isHorizontal = false, isVertical = false;
                if ((points[i][1] - points[j][1]) == 0.0) {
                    // Horizontal line
                    isHorizontal = true;
                } else if ((points[i][0] - points[j][0]) == 0.0) {
                    // Vertical line
                    isVertical = true;
                } else {
                    a = (double) (points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);
                }
                var b = points[i][1] - a * points[i][0];
                // Find max points passing through points[i] and points[j]
                for (var k = 0; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if (isHorizontal) {
                        if (points[k][1] == points[i][1]) {
                            nbPoints++;
                        }
                    } else if (isVertical) {
                        if (points[k][0] == points[i][0]) {
                            nbPoints++;
                        }
                    } else {
                        var y = a * points[k][0] + b;
                        if (Math.abs(y - points[k][1]) <= 0.0001) {
                            nbPoints++;
                        }
                    }
                }
                maxPoints = Math.max(maxPoints, nbPoints);
            }
        }
        return maxPoints;
    }
}
