package dev.seifeddinedridi.codingchallenges;

public class BinaryTreePathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null && (targetSum - root.val) == 0) {
            return true;
        }
        if (root.left != null && hasPathSum(root.left, targetSum - root.val)) {
            return true;
        }
        return root.right != null && hasPathSum(root.right, targetSum - root.val);
    }
}
