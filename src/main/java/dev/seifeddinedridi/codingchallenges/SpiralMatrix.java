package dev.seifeddinedridi.codingchallenges;

import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        var m = matrix.length;
        var n = matrix[0].length;
        var bbox = new int[]{0, n - 1, 0, m - 1}; // left right top bottom
        while (bbox[1] >= bbox[0] && bbox[3] >= bbox[2]) {
            // Calculate the number of steps along the perimeter of the current bounding box
            var width = bbox[1] - bbox[0] + 1;
            var height = bbox[3] - bbox[2] + 1;
            if (width == 1 || height == 1) {
                var alongWidth = width != 1;
                // Edge case
                for (int i = 0; i < Math.max(width, height); i++) {
                    var x = alongWidth ? bbox[2] : bbox[2] + i;
                    var y = alongWidth ? bbox[0] + i : bbox[0];
                    ans.add(matrix[x][y]);
                }
            } else {
                var nbSteps = width * 2 + height * 2 - 1;
                var i = 0;
                while (i < nbSteps) {
                    if (i == width || (i == width + height) || (i == width * 2 + height)) {
                        // Skip corners
                        i++;
                        continue;
                    }
                    int x, y;
                    if (i < width) {
                        x = bbox[2];
                        y = bbox[0] + i;
                    } else if (i < width + height) {
                        x = bbox[2] + i - width;
                        y = bbox[1];
                    } else if (i < 2 * width + height) {
                        x = bbox[3];
                        y = bbox[1] - (i - width - height);
                    } else {
                        x = bbox[3] - (i - 2 * width - height);
                        y = bbox[0];
                    }
                    ans.add(matrix[x][y]);
                    i++;
                }
            }
            // Shrink the bounding box by one unit on each side
            bbox[0]++; // left
            bbox[1]--; // right
            bbox[2]++; // top
            bbox[3]--; // bottom
        }
        return ans;
    }
}
