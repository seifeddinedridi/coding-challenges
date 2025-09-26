package dev.seifeddinedridi.codingchallenges;

public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return goodNodes(root, root.val);
    }

    public int goodNodes(TreeNode parent, int maxNodeValue) {
        var count = 0;
        if (maxNodeValue <= parent.val) {
            maxNodeValue = parent.val;
            count++;
        }
        if (parent.left != null) {
            count += goodNodes(parent.left, maxNodeValue);
        }
        if (parent.right != null) {
            count += goodNodes(parent.right, maxNodeValue);
        }
        return count;
    }
}
