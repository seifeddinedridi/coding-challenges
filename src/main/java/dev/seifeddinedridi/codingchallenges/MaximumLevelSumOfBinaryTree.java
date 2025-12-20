package dev.seifeddinedridi.codingchallenges;

import java.util.LinkedList;

public class MaximumLevelSumOfBinaryTree {

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int level = 1;
        int currentLevel = 1;
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            var secondaryQueue = new LinkedList<TreeNode>();
            var sum = 0;
            while (!queue.isEmpty()) {
                var node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    secondaryQueue.offer(node.left);
                }
                if (node.right != null) {
                    secondaryQueue.offer(node.right);
                }
            }
            queue = secondaryQueue;
            if (max < sum) {
                level = currentLevel;
                max = sum;
            }
            currentLevel++;
        }
        return level;
    }
}
