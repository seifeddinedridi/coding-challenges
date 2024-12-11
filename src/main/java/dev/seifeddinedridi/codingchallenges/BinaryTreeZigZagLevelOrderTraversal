package dev.seifeddinedridi.codingchallenges;

public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        var ans = new ArrayList<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        var secondaryQueue = new LinkedList<TreeNode>();
        var values = new ArrayList<Integer>();
        queue.add(root);
        ans.add(List.of(root.val));
        var leftToRight = false;
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
            if (queue.isEmpty()) {
                queue = secondaryQueue;
                if (!values.isEmpty()) {
                    if (leftToRight) {
                        ans.add(values);
                    } else {
                        Collections.reverse(values);
                        ans.add(values);
                    }
                    values = new ArrayList<Integer>();
                }
                leftToRight = leftToRight ? false : true;
                secondaryQueue = new LinkedList<>();
            }
        }
        return ans;
    }
}
