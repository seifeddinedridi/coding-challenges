package dev.seifeddinedridi.codingchallenges;

public class BinaryTreeMaximumPathSum {

    private int maxPathSum(TreeNode node, int[] maxSum) {
        if (node.left == null && node.right == null) {
            maxSum[0] = Math.max(node.val, maxSum[0]);
            return node.val;
        }
        var maxLeft = -1001;
        if (node.left != null) {
            maxLeft = maxPathSum(node.left, maxSum);
        }
        var maxRight = -1001;
        if (node.right != null) {
            maxRight = maxPathSum(node.right, maxSum);
        }
        maxSum[0] = Math.max(node.val, maxSum[0]);
        maxSum[0] = Math.max(node.val + maxLeft, maxSum[0]);
        maxSum[0] = Math.max(node.val + maxRight, maxSum[0]);
        maxSum[0] = Math.max(maxLeft, maxSum[0]);
        maxSum[0] = Math.max(maxRight, maxSum[0]);
        maxSum[0] = Math.max(node.val + maxLeft + maxRight, maxSum[0]);
        return Math.max(node.val, node.val + Math.max(maxLeft, maxRight));
    }
}
