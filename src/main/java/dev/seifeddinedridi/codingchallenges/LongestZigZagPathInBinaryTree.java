package dev.seifeddinedridi.codingchallenges;

public class LongestZigZagPathInBinaryTree {

    public int longestZigZag(TreeNode root) {
        // Traverse the tree in a depth-first manner
        // Keep track of the current depth and the previous direction
        // If it is not possible to switch direction, update the global maxLength and reset the counter
        return longestZigZag(root, -1, false);
    }

    private int longestZigZag(TreeNode root, int currentLength, boolean presviousIsLeft) {
        if (root == null) {
            return 0;
        }
        var leftZigZagLength = currentLength + 1;
        if (root.left != null) {
            var newLength = presviousIsLeft ? 0 : currentLength + 1;
            leftZigZagLength = Math.max(longestZigZag(root.left, newLength, true), leftZigZagLength);
        }
        var rightZigZagLength = currentLength + 1;
        if (root.right != null) {
            var newLength = !presviousIsLeft ? 0 : currentLength + 1;
            rightZigZagLength = Math.max(longestZigZag(root.right, newLength, false), rightZigZagLength);
        }
        return Math.max(leftZigZagLength, rightZigZagLength);
    }
}
