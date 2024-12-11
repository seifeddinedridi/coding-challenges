package dev.seifeddinedridi.codingchallenges;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) {
          return List.of();
      }
      var ans = new ArrayList<List<Integer>>();
      var queue = new LinkedList<TreeNode>();
      queue.add(root);
      ans.add(List.of(root.val));
      while (!queue.isEmpty()) {
          var secondaryQueue = new LinkedList<TreeNode>();
          var values = new ArrayList<Integer>();
          while (!queue.isEmpty()) {
              var node = queue.poll();
              if (node.left != null) {
                  secondaryQueue.add(node.left);
                  values.add(node.left.val);
              }
              if (node.right != null) {
                  secondaryQueue.add(node.right);
                  values.add(node.right.val);
              }
          }
          queue.addAll(secondaryQueue);
          if (!values.isEmpty()) {
              ans.add(values);
          }
      }
      return ans;
  }
}
