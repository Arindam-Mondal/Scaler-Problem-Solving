package advance.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/**
 *  Subsets II
 * Stuck somewhere?
 * Ask for help from a TA and get it resolved.
 * Get help from TA.
 * Problem Description
 * Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.
 *
 * NOTE:
 *
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * The subsets must be sorted lexicographically.
 *
 *
 * Problem Constraints
 * 0 <= N <= 16
 *
 *
 *
 * Input Format
 * Only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return a 2-D vector denoting all the possible subsets.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 2]
 * Input 2:
 *
 *  A = [1, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [
 *     [],
 *     [1],
 *     [1, 2],
 *     [1, 2, 2],
 *     [2],
 *     [2, 2]
 *  ]
 * Output 2:
 *
 *  [
 *     [],
 *     [1],
 *     [1, 1]
 *  ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * All the subsets of the array [1, 2, 2] in lexicographically sorted order.
 */
public class SubSetII {

    class CustomComparator implements Comparator<ArrayList<Integer>>
    {
        public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
            for(int i = 0; i <a.size() && i < b.size(); i++){
                if(a.get(i) < b.get(i)) return -1;
                if(a.get(i) > b.get(i)) return 1;
            }
            if(a.size() > b.size()) return 1;
            return -1;
        }
    }

    public class Solution {
        public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
            A.sort((a,b)->a.compareTo(b));

            HashSet<ArrayList<Integer>> set = new HashSet<>();
            findSubset(A,0,new ArrayList<>(),set);
            ArrayList<ArrayList<Integer>> result = new ArrayList<>(set);
            Collections.sort(result,new CustomComparator());
            return result;
        }

        public void findSubset(ArrayList<Integer> A,int pos,ArrayList<Integer> temp,HashSet<ArrayList<Integer>> set){

            if(pos == A.size()){
                set.add(new ArrayList<>(temp));
                return;
            }

            //take the pos
            temp.add(A.get(pos));
            findSubset(A,pos+1,temp,set);
            temp.remove(temp.size()-1);
            findSubset(A,pos+1,temp,set);

        }
    }
}
