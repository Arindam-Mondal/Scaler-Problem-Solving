package advance.tree;

class NodeHelper{
    Boolean isValid;
    Integer noOfNodes;
    Integer min;
    Integer max;
    NodeHelper(Boolean isValid){
        this.isValid = isValid;
        noOfNodes = 0;
        min = null;
        max = null;
    }
}

public class LargestBSTSubTree {
    public int solve(TreeNode A) {
        NodeHelper nodeHelper = postOrderTraversal(A);
        return nodeHelper.noOfNodes;


    }
    public NodeHelper postOrderTraversal(TreeNode A){
        NodeHelper nodeHelper = new NodeHelper(false);
        if(A==null){
            nodeHelper.isValid =true;
            return nodeHelper;
        }

        NodeHelper left = postOrderTraversal(A.left);
        NodeHelper right = postOrderTraversal(A.right);

        int min = left.max == null ? A.val : left.max;
        int max = right.min == null ? A.val : right.min;
        if(left.isValid && right.isValid){
            if(min<=A.val && A.val<=max){
                nodeHelper.isValid = true;
                nodeHelper.min =min;
                nodeHelper.max =max;
            }

        }
        if(nodeHelper.isValid){
            nodeHelper.noOfNodes = left.noOfNodes + right.noOfNodes + 1;
        }else {
            nodeHelper.noOfNodes = Math.max(left.noOfNodes,right.noOfNodes);
        }
        return nodeHelper;
    }
}
