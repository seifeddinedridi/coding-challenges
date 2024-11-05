package dev.seifeddinedridi.codingchallenges;// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LongestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Return a node that is an ancestor of both p and q, null otherwise.
        if (root == null || root == p || root == q) {
            return root;
        }
        var node1 = lowestCommonAncestor(root.left, p, q); // We might have found both nodes p and q
        var node2 = lowestCommonAncestor(root.right, p, q);
        // A node cannot exist on both branches
        // If node1 and node are not null then the ancestor is root
        // Else the ancestor it the node that is not null

        if (node1 != null && node2 == null) {
            return node1;
        } else if (node1 == null && node2 != null) {
            return node2;
        } else if (node1 != null && node2 != null) {
            return root;
        } else {
            return null;
        }

        //return node1 != null && node1 != node2 ? root : (node1 != null ? node1 : node2);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // Given a node, determine if it is an ancestor of another one
        // Walk through all the nodes in a breadth-first manner (BFS)
        // and check if that node is an ancestor of p and q

        // a better ancestor is one closer to p and q. In other words
        // dist(n, p) + dist(n, q) is minimal.

        // Step 1: store distances relative to the root
        List<Integer> heights = new ArrayList<>();
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        var height = 0;
        var nodeIndex = 0;
        var pIndex = -1;
        var qIndex = -1;
        while (!queue.isEmpty()) {
            var l2Queue = new LinkedList<TreeNode>();
            // We poll all the nodes at the current level
            while (!queue.isEmpty()) {
                var node = queue.poll();
                heights.add(height);
                if (node == p) {
                    pIndex = nodeIndex;
                } else if (node == q) {
                    qIndex = nodeIndex;
                }
                if (node.left != null) {
                    l2Queue.add(node.left);
                }
                if (node.right != null) {
                    l2Queue.add(node.right);
                }
                nodeIndex++;
            }
            height++;
            queue.addAll(l2Queue);
        }

        if (pIndex == -1 || qIndex == -1) {
            return null;
        }

        // Step 2: visit each node and keep track of the node
        // that has the lowest dist(n, p) + dist(n, q)

        // But first we have to find out if a node is an ancestor of both nodes q and p
        // A node is an ancestor of another if there is a top-down path from the first to the second node
        queue = new LinkedList<TreeNode>();
        queue.add(root);
        nodeIndex = 0;
        var minDist = Integer.MAX_VALUE;
        TreeNode lca = null;
        while (!queue.isEmpty()) {
            var l2Queue = new LinkedList<TreeNode>();
            // We poll all the nodes at the current level
            while (!queue.isEmpty()) {
                var node = queue.poll();
                if (isAncestor(node, p, q)) {
                    var distP = heights.get(pIndex) - heights.get(nodeIndex);
                    var distQ = heights.get(qIndex) - heights.get(nodeIndex);
                    if (distP >= 0 && distQ >= 0) {
                        if (minDist > distP + distQ) {
                            minDist = distP + distQ;
                            lca = node;
                        }
                    }
                }
                if (node.left != null) {
                    l2Queue.add(node.left);
                }
                if (node.right != null) {
                    l2Queue.add(node.right);
                }
                nodeIndex++;
            }
            queue.addAll(l2Queue);
        }
        return lca;
    }

    private boolean isAncestor(TreeNode node1, TreeNode node2, TreeNode node3) {
        var queue = new LinkedList<TreeNode>();
        queue.add(node1);
        var reachedN2 = false;
        var reachedN3 = false;
        while (!queue.isEmpty()) {
            var n = queue.poll();
            if (n == node2) {
                reachedN2 = true;
            } else if (n == node3) {
                reachedN3 = true;
            }
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
        return reachedN2 && reachedN3;
    }
}