package dev.seifeddinedridi.codingchallenges;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root, targetSum, 0, new HashMap<>());
    }

    private int pathSum(TreeNode root, long targetSum, long prefixSum, Map<Long, Integer> cumulativeSums) {
        var count = 0;
        prefixSum += root.val;
        if (cumulativeSums.containsKey(prefixSum - targetSum)) {
            count += cumulativeSums.get(prefixSum - targetSum);
        }
        if (prefixSum == targetSum) {
            count++;
        }
        cumulativeSums.computeIfAbsent(prefixSum, k -> 0);
        cumulativeSums.computeIfPresent(prefixSum, (k, v) -> v + 1);
        if (root.left != null) {
            count += pathSum(root.left, targetSum, prefixSum, cumulativeSums);
        }
        if (root.right != null) {
            count += pathSum(root.right, targetSum, prefixSum, cumulativeSums);
        }
        cumulativeSums.computeIfPresent(prefixSum, (k, v) -> {
            if (v == 1) {
                return null;
            }
            return v - 1;
        });
        return count;
    }
}
