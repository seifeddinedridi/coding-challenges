package dev.seifeddinedridi.codingchallenges;

public class SortedArrayToBinaryTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (right == left) {
            return new TreeNode(nums[left]);
        } else if (right - left == 1) {
            if (nums[left] < nums[right]) {
                return new TreeNode(nums[right], new TreeNode(nums[left]), null);
            } else {
                return new TreeNode(nums[left], new TreeNode(nums[right]), null);
            }
        } else {
            var median = (left + right) / 2;
            var node = new TreeNode(nums[median]);
            node.left = buildTree(nums, left, median - 1);
            node.right = buildTree(nums, median + 1, right);
            return node;
        }
    }
}
