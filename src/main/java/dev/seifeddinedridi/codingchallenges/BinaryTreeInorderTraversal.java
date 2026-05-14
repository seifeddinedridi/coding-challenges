package dev.seifeddinedridi.codingchallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        var stack = new Stack<TreeNode>();
        var nodeValues = new ArrayList<Integer>();
        var node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            nodeValues.add(node.val);
            node = node.right;
        }
        return nodeValues;
    }
}
