package advance.tree;

import java.util.*;

/**
 * Vertical Order traversal
 *
 * Problem Description
 * Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
 *
 *
 * NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
 *
 *
 *
 * Problem Constraints
 * 0 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First and only arument is a pointer to the root node of binary tree, A.
 *
 *
 *
 * Output Format
 * Return a 2D array denoting the vertical order traversal of tree as shown.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *       6
 *     /   \
 *    3     7
 *   / \     \
 *  2   5     9
 * Input 2:
 *
 *       1
 *     /   \
 *    3     7
 *   /       \
 *  2         9
 *
 *
 * Example Output
 * Output 1:
 *
 *  [
 *     [2],
 *     [3],
 *     [6, 5],
 *     [7],
 *     [9]
 *  ]
 * Output 2:
 *
 *  [
 *     [2],
 *     [3],
 *     [1],
 *     [7],
 *     [9]
 *  ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  First row represent the verical line 1 and so on.
 */
public class VerticalOrderTraversal {
    class LevelOrderTree{
        TreeNode treeNode;
        int level;
        LevelOrderTree(TreeNode treeNode, int level){
            this.treeNode = treeNode;
            this.level = level;
        }
    }
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        //HashMap to store the verical level and TreeNode
        Map<Integer,ArrayList<Integer>> verticalMap = new HashMap<>();
        Queue<LevelOrderTree> queue = new LinkedList<>();
        int minLevel = Integer.MAX_VALUE;
        int maxLevel = Integer.MIN_VALUE;
        if(A!=null){
            LevelOrderTree lot = new LevelOrderTree(A,0);
            queue.add(lot);
            queue.add(null);
        }
        while(!queue.isEmpty() && queue.peek() != null){
            while(queue.peek() != null){
                LevelOrderTree lot = queue.poll();
                TreeNode treeNode = lot.treeNode;
                int level = lot.level;
                minLevel = Math.min(minLevel,lot.level);
                maxLevel = Math.max(maxLevel,lot.level);
                if(verticalMap.get(level) != null){
                    ArrayList<Integer> levelList = verticalMap.get(level);
                    levelList.add(treeNode.val);
                    verticalMap.put(level,levelList);
                }else{
                    ArrayList<Integer> levelList = new ArrayList<>();
                    levelList.add(treeNode.val);
                    verticalMap.put(level,levelList);
                }
                if(treeNode.left != null){
                    LevelOrderTree llot = new LevelOrderTree(treeNode.left,level - 1);
                    queue.add(llot);
                }
                if(treeNode.right != null){
                    LevelOrderTree rlot = new LevelOrderTree(treeNode.right,level + 1);
                    queue.add(rlot);
                }
            }
            queue.remove();
            queue.add(null);
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=minLevel;i<=maxLevel;i++){
            result.add(verticalMap.get(i));
        }
        return result;
    }
}
