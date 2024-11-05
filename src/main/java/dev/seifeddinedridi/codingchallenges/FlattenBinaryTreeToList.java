package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/flatten-binary-tree-to-linked-list

import java.util.Deque;
import java.util.LinkedList;

class FlattenBinaryTreeToList {

    public void flatten(TreeNode root) {
        // Find the leaf node on the left subtree
        // We have to always pass the parent node to the recursive function
        visit(new LinkedList<>(), root);
    }

    private void visit(Deque<TreeNode> ans, TreeNode node) {
        if (node == null) {
            return;
        }
        var n = node;
        var left = node.left;
        var right = node.right;
        n.left = null;
        n.right = null;
        if (!ans.isEmpty()) {
            var prev = ans.poll();
            prev.right = n;
        }
        ans.push(n);
        // Visit left
        if (left != null) {
            // Find the tail of the linked-list
            visit(ans, left);
        }
        if (right != null) {
            // Find tail of the linked list
            visit(ans, right);
        }
    }
}