package dev.seifeddinedridi.codingchallenges

public class BSTIterator {

    private Stack<TreeNode> stack;
    private boolean isGoingDown;

    public BSTIterator(TreeNode root) {
        // Visit left subtree
        // Visit node
        // Visit right subtree
        this.stack = new Stack<>();
        this.stack.push(root);
        this.isGoingDown = root != null && (root.left != null || root.right != null);
    }
    
    public int next() {
        // Going up is polling
        // Going down is pushing
        if (isGoingDown) {
            if (!stack.isEmpty()) {
                var node = stack.pop();
                stack.push(node);
                if (node.left != null) {
                    stack.push(node.left);
                } else {
                    isGoingDown = false;
                }
                return next();
            }
        } else {
            if (!stack.isEmpty()) {
                var node = stack.pop();
                isGoingDown = node.right != null;
                if (isGoingDown) {
                    stack.push(node.right);
                }
                return node.val;
            }
        }
        return -1;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
