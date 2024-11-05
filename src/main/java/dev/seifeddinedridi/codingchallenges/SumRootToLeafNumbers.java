package dev.seifeddinedridi.codingchallenges;

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return sumLeafPaths(root, root.val);
    }

    private int sumLeafPaths(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return currentSum;
        } else {
            // Each time we go one level down, we multiply the existing sum by 10
            var sum = 0;
            if (node.left != null) {
                sum = sumLeafPaths(node.left, currentSum * 10 + node.left.val);
            }
            if (node.right != null) {
                sum += sumLeafPaths(node.right, currentSum * 10 + node.right.val);
            }
            return sum;
        }
    }
}
