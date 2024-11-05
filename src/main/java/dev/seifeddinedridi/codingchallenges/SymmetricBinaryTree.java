package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SymmetricBinaryTree {

    public boolean isSymmetricIterative(TreeNode root) {
        var leftQueue = new LinkedList<TreeNode>();
        var rightQueue = new LinkedList<TreeNode>();
        leftQueue.add(root.left);
        rightQueue.add(root.right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            // Dequeue all the nodes at the current level
            var nextLeftNodes = new LinkedList<TreeNode>();
            var nextRightNodes = new LinkedList<TreeNode>();
            while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
                var n1 = leftQueue.poll();
                var n2 = rightQueue.poll();
                if (n1 == null && n2 != null || n1 != null && n2 == null || n1 != null && n1.val != n2.val) {
                    return false;
                }
                if (n1 != null) {
                    nextLeftNodes.add(n1.left);
                    nextLeftNodes.add(n1.right);
                }
                if (n2 != null) {
                    nextRightNodes.add(n2.right);
                    nextRightNodes.add(n2.left);
                }
            }
            leftQueue.addAll(nextLeftNodes);
            rightQueue.addAll(nextRightNodes);
        }
        return leftQueue.isEmpty() && rightQueue.isEmpty();
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftSubtree, TreeNode rightSubtree) {
        if ((leftSubtree == null && rightSubtree != null) || (leftSubtree != null && rightSubtree == null)
                || leftSubtree != null && leftSubtree.val != rightSubtree.val) {
            return false;
        } else if (leftSubtree == rightSubtree) {
            return true;
        }
        return isSymmetric(leftSubtree.left, rightSubtree.right) && isSymmetric(leftSubtree.right, rightSubtree.left);
    }

    public boolean isSymmetricExtraMemory(TreeNode root) {
        var leftNodes = new ArrayList<Integer>();
        gatherNodes(root.left, true, leftNodes);
        var rightNodes = new ArrayList<Integer>();
        gatherNodes(root.right, false, rightNodes);
        return leftNodes.equals(rightNodes);
    }

    private void gatherNodes(TreeNode node, boolean leftFirst, List<Integer> out) {
        if (node != null) {
            gatherNodes(leftFirst ? node.left : node.right, leftFirst, out);
            if (leftFirst) {
                out.add(node.left != null ? node.left.val : -101);
            } else {
                out.add(node.right != null ? node.right.val : -101);
            }
            out.add(node.val);
            gatherNodes(leftFirst ? node.right : node.left, leftFirst, out);
            if (leftFirst) {
                out.add(node.right != null ? node.right.val : -101);
            } else {
                out.add(node.left != null ? node.left.val : -101);
            }
        }
    }
}
