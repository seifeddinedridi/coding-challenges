package dev.seifeddinedridi.codingchallenges;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int min, int max) {
        if (root.val < min || root.val > max) {
            return false;
        }
        var isValid = root.left == null || (root.left.val < root.val && isValidBST(root.left, min, root.val - 1));
        if (root.right != null && isValid) {
            isValid = root.right.val > root.val && isValidBST(root.right, root.val + 1, max);
        }
        return isValid;
    }
}
