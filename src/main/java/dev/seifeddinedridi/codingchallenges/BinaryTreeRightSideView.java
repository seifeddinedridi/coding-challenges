package dev.seifeddinedridi.codingchallenges;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        var ans = new ArrayList<Integer>();
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var secondaryQueue = new LinkedList<TreeNode>();
            while (!queue.isEmpty()) {
                var node = queue.poll();
                if (node.left != null) {
                    secondaryQueue.add(node.left);
                }
                if (node.right != null) {
                    secondaryQueue.add(node.right);
                }
                if (queue.isEmpty()) {
                    ans.add(node.val);
                }
            }
            queue.addAll(secondaryQueue);
        }
        return ans;
    }
}
