package dev.seifeddinedridi.codingchallenges;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPostorderAndInorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        var valueToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            valueToIndex.put(inorder[i], i);
        }
        return buildTree(valueToIndex, postorder,
                0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(Map<Integer, Integer> valueToIndex,
                               int[] postorder,
                               int startIndexInorder, int endIndexInorder,
                               int startIndexPostorder, int endIndexPostorder) {
        if (startIndexInorder > endIndexInorder || startIndexPostorder > endIndexPostorder) {
            return null;
        }
        var node = new TreeNode(postorder[endIndexPostorder]);
        var midIndex = valueToIndex.get(node.val);
        // Inorder left subtreee size
        var leftSubtreeSize = midIndex - startIndexInorder;
        // Inorder right subtree size
        var rightSubstreeSize = endIndexInorder - midIndex;
        node.left = buildTree(valueToIndex, postorder,
                startIndexInorder, midIndex - 1,
                startIndexPostorder, endIndexPostorder - rightSubstreeSize - 1);

        node.right = buildTree(valueToIndex, postorder,
                midIndex + 1, endIndexInorder,
                startIndexPostorder + leftSubtreeSize, endIndexPostorder - 1);
        return node;
    }
}
