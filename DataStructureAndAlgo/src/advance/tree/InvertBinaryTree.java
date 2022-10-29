package advance.tree;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode A) {
        invertTreeNode(A);
        return A;
    }

    public void invertTreeNode(TreeNode A){
        if(A==null){
            return;
        }
        TreeNode left = A.left;
        A.left = A.right;
        A.right = left;

        invertTreeNode(A.left);
        invertTreeNode(A.right);
    }
}
