package dev.seifeddinedridi.codingchallenges;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[] {0};
        maxDiameter(root, max);
        return max[0];
    }

    private int maxDiameter(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }
        int depthL = 0, depthR = 0;
        if (node.left != null) {
            depthL = maxDiameter(node.left, max);
        }
        if (node.right != null) {
            depthR = maxDiameter(node.right, max);
        }
        max[0] = Math.max(depthL + depthR, max[0]);
        return Math.max(depthL, depthR) + 1;
    }
}
