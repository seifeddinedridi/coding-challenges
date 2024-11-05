package dev.seifeddinedridi.codingchallenges;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        // Determine the depth of the tree
        // Find the first branch that is not complete
        // totalNodeCount = 1 + 2^1 + 2^2 + ... + 2^h
        // nodeCount = totalNodeCount - numberOfIncompleteBranches
        var maxDepth = getDepth(root);
        var ans = new int[] {0};
        countIncompleteBranches(root.right, 1, maxDepth, ans);
        countIncompleteBranches(root.left, 1, maxDepth, ans);
        return ((int) Math.pow(2, maxDepth)) - 1 - ans[0];
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getDepth(node.left);
    }

    private int countIncompleteBranches(TreeNode node, int currentDepth, int maxDepth, int[] ans) {
        // Stop visiting the nodes when finding the first complete branch
        if (node == null) {
            ans[0] += (currentDepth < maxDepth ? 1 : 0);
            return currentDepth;
        }
        if (countIncompleteBranches(node.right, currentDepth + 1, maxDepth, ans) < maxDepth) {
            countIncompleteBranches(node.left, currentDepth + 1, maxDepth, ans);
        }
        return currentDepth;
    }
}
