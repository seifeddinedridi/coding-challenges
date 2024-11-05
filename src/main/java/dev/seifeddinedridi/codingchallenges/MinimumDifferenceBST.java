package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class MinimumDifferenceBST {

    public int getMinimumDifference(TreeNode root) {
        var nodes = new ArrayList<Integer>();
        visitNode(root, nodes);
        var minDifference = (int) 10e5;
        for (int i = 0; i < nodes.size() - 1; i++) {
            minDifference = Math.min(minDifference, nodes.get(i + 1) - nodes.get(i));
        }
        return minDifference;
    }

    public int getMinimumDifference2(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        var minDifference = (int) 10e5;
        while (!queue.isEmpty()) {
            var node = queue.pop();
            minDifference = Math.min(minDifference, getHeight(node, node.val));
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return minDifference;
    }

    private void visitNode(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            visitNode(node.left, nodes);
        }
        nodes.add(node.val);
        if (node.right != null) {
            visitNode(node.right, nodes);
        }
    }

    private int getHeight(TreeNode node, int rootValue) {
        var left = (int) 10e5;
        if (node.left != null) {
            left = Math.min(Math.abs(rootValue - node.left.val), getHeight(node.left, rootValue));
        }
        var right = (int) 10e5;
        if (node.right != null) {
            right = Math.min(Math.abs(node.right.val - rootValue), getHeight(node.right, rootValue));
        }
        return Math.min(left, right);
    }
}
