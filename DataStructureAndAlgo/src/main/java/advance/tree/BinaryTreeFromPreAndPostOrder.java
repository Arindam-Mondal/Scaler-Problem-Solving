package advance.tree;

import advance.tree.TreeNode;
import java.util.ArrayList;

public class BinaryTreeFromPreAndPostOrder {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

        if(A.size() == 0 || B.size() == 0){
            return null;
        }

        //B.last is always root;
        int na = A.size();
        int nb = B.size();

        TreeNode root = new TreeNode(B.get(nb-1));
        //splitList
        ArrayList<ArrayList<Integer>> splitList = splitList(A,B,B.get(nb-1));
        ArrayList<Integer> inorderleft = splitList.get(0);
        ArrayList<Integer> inorderRight = splitList.get(1);
        ArrayList<Integer> postOrderLeft = splitList.get(2);
        ArrayList<Integer> postOrderRight = splitList.get(3);

        root.left = buildTree(inorderleft,postOrderLeft);
        root.right = buildTree(inorderRight,postOrderRight);

        return root;
    }

    public ArrayList<ArrayList<Integer>> splitList(ArrayList<Integer> A, ArrayList<Integer> B, int el){

        ArrayList<Integer> inorderleft = new ArrayList<>();
        ArrayList<Integer> inorderRight = new ArrayList<>();
        ArrayList<Integer> postOrderLeft = new ArrayList<>();
        ArrayList<Integer> postOrderRight = new ArrayList<>();
        int n = A.size();
        int pos = -1;
        //first search the position of n in the array
        for(int i=0;i<n;i++){
            if(A.get(i) == el){
                pos = i;
                break;
            }
        }
        int j = 0;
        while(j<pos){
            inorderleft.add(A.get(j));
            postOrderLeft.add(B.get(j));
            j++;
        }
        j++;
        while(j<n){
            inorderRight.add(A.get(j));
            postOrderRight.add(B.get(j-1));
            j++;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(inorderleft);
        result.add(inorderRight);
        result.add(postOrderLeft);
        result.add(postOrderRight);
        return result;
    }
}
