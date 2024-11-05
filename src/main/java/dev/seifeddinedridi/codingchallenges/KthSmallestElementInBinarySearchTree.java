package dev.seifeddinedridi.codingchallenges;

public class KthSmallestElementInBinarySearchTree {

    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[2];
        returnKthSmallestValue(root, k, ans);
        // If new value < node[k] -> node[k - 1]
        // If new value > node[k] -> same

        // If deleted value < node[k] -> node[k + 1]
        // If deleted value > node[k] -> same
        return ans[0];
    }

    private void returnKthSmallestValue(TreeNode node, int k, int[] ans) {
        if (ans[1] < k && node.left != null) {
            returnKthSmallestValue(node.left, k, ans);
        }
        // Visit current node
        ans[1]++;
        if (ans[1] == k) {
            ans[0] = node.val;
        }
        if (ans[1] < k && node.right != null) {
            returnKthSmallestValue(node.right, k, ans);
        }
    }
}
