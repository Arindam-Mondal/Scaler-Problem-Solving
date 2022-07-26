package intermediate.subsetandsubsequence;

import java.util.ArrayList;

/**
 * Problem Description
 * Given a set of distinct integers A, return all possible subsets.
 *
 * NOTE:
 *
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 16
 * INTMIN <= A[i] <= INTMAX
 *
 *
 * Input Format
 * First and only argument of input contains a single integer array A.
 *
 *
 *
 * Output Format
 * Return a vector of vectors denoting the answer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1]
 * Input 2:
 *
 * A = [1, 2, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 * [
 *     []
 *     [1]
 * ]
 * Output 2:
 *
 * [
 *  []
 *  [1]
 *  [1, 2]
 *  [1, 2, 3]
 *  [1, 3]
 *  [2]
 *  [2, 3]
 *  [3]
 * ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  You can see that these are all possible subsets.
 * Explanation 2:
 *
 * You can see that these are all possible subsets.
 */
public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //for loop to get the nos
        A.sort((a,b)->a.compareTo(b));
        for(int i=0;i<Math.pow(2,A.size());i++){
            ArrayList<Integer> tempList= new ArrayList<>();
            for(int j=1;j<=A.size();j++){
                if(isSetBit(i,j)){
                    tempList.add(A.get(j-1));
                }
            }
            result.add(tempList);
        }
        result.sort((a,b)->compareList(a,b));
        return result;
    }

    public boolean isSetBit(int n, int k){
        return ((n>>k-1) & 1) == 1;
    }

    public int compareList(ArrayList<Integer> a, ArrayList<Integer> b){
        int sa = 0;
        int sb = 0;
        while(sa < a.size() && sb < b.size()){

            if(a.get(sa) < b.get(sb)){
                return -1;
            }else if(a.get(sa) > b.get(sb)){
                return 1;
            }

            sa++;
            sb++;
        }

        if(sa == a.size()){
            return -1;
        }

        if(sb == b.size()){
            return 1;
        }

        return 0;

    }
}
