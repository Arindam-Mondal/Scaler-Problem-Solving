package advance.backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem Description
 * Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.
 * The same repeated number may be chosen from A unlimited number of times.
 * Note:
 * 1) All numbers (including target) will be positive integers.
 * 2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * 3) The combinations themselves must be sorted in ascending order.
 * 4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
 * 5) The solution set must not contain duplicate combinations.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 20
 * 1 <= A[i] <= 50
 * 1 <= B <= 500
 *
 *
 * Input Format
 * The first argument is an integer array A.
 * The second argument is integer B.
 *
 *
 * Output Format
 * Return a vector of all combinations that sum up to B.
 *
 *
 * Example Input
 * Input 1:
 * A = [2, 3]
 * B = 2
 * Input 2:
 * A = [2, 3, 6, 7]
 * B = 7
 *
 *
 * Example Output
 * Output 1:
 * [ [2] ]
 * Output 2:
 * [ [2, 2, 3] , [7] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 * All possible combinations are listed.
 * Explanation 2:
 * All possible combinations are listed.
 */
public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<Integer> uniqueCandidates = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            if(i==0 || A.get(i)!=A.get(i-1)){
                uniqueCandidates.add(A.get(i));
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(uniqueCandidates,new ArrayList<>(),0,B,0,result);
        return result;
    }


    public void helper(ArrayList<Integer> actual, ArrayList<Integer> current,int pos, int target, int currentSum, ArrayList<ArrayList<Integer>> result){

        if(currentSum>target){
            return;
        }
        if(currentSum == target){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=pos;i<actual.size();i++){

            current.add(actual.get(i));
            currentSum = currentSum + actual.get(i);

            helper(actual,current,i,target,currentSum,result);

            current.remove(current.size()-1);
            currentSum = currentSum - actual.get(i);

        }
    }
}
