package tree;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal_889 {
    // preorder: root -> left -> right
    // postorder: left -> right -> root

    int preIndex = 0;
    int postIndex = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructTree(preorder, postorder);
    }

    private TreeNode constructTree(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndex++]);
        // there's a left tree
        if (root.val != postorder[postIndex]) {
            root.left = constructTree(preorder, postorder);
        }

        // there's a right tree
        if (root.val != postorder[postIndex]) {
            root.right = constructTree(preorder, postorder);
        }

        // reached the next root in the postOrder
        postIndex++;

        return root;
    }
}
