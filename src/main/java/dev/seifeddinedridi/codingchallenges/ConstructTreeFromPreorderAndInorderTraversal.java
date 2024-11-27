package dev.seifeddinedridi.codingchallenges;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var valueToInorderIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            valueToInorderIndex.put(inorder[i], i);
        }
        return buildSubtree(valueToInorderIndex, preorder,
                0, inorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildSubtree(Map<Integer, Integer> valueToInorderIndex,
                                  int[] preorder,
                                  int inStart, int inEnd,
                                  int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        var node = new TreeNode(preorder[preStart]);
        int nodeIndex = valueToInorderIndex.get(node.val);
        int leftSubtreeSize = nodeIndex - inStart;
        node.left = buildSubtree(valueToInorderIndex, preorder,
                inStart, nodeIndex - 1,
                preStart + 1, preStart + leftSubtreeSize);
        node.right = buildSubtree(valueToInorderIndex, preorder,
                nodeIndex + 1, inEnd,
                preStart + leftSubtreeSize + 1, preEnd);
        return node;
    }
}
