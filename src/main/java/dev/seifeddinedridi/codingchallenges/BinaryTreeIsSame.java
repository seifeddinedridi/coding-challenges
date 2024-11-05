package dev.seifeddinedridi.codingchallenges;

import java.util.LinkedList;

public class BinaryTreeIsSame {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        } else {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }
        var queue1 = new LinkedList<TreeNode>();
        queue1.add(p);
        var queue2 = new LinkedList<TreeNode>();
        queue2.add(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            var secondaryQueue1 = new LinkedList<TreeNode>();
            var secondaryQueue2 = new LinkedList<TreeNode>();
            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                var node1 = queue1.poll();
                var node2 = queue2.poll();
                var cond = (node1 == null && node2 != null) || node1 != null && node2 == null;
                if (cond || node1 != null && node1.val != node2.val) {
                    return false;
                }
                if (node1 != null) {
                    secondaryQueue1.add(node1.left);
                    secondaryQueue1.add(node1.right);
                }
                if (node2 != null) {
                    secondaryQueue2.add(node2.left);
                    secondaryQueue2.add(node2.right);
                }
            }
            queue1.addAll(secondaryQueue1);
            queue2.addAll(secondaryQueue2);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
