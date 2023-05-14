package advance.twopointers;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * 3 Sum Zero
 *
 * Problem Description
 *
 * Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0
 *
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.
 *
 *
 *
 * Problem Constraints
 *
 * 0 <= N <= 7000
 *
 * -108 <= A[i] <= 108
 *
 *
 *
 * Input Format
 *
 * Single argument representing a 1-D array A.
 *
 *
 *
 * Output Format
 *
 * Output a 2-D vector where each row represent a unique triplet.
 *
 *
 *
 * Example Input
 *
 * A = [-1,0,1,2,-1,4]
 *
 *
 * Example Output
 *
 * [ [-1,0,1],
 *   [-1,-1,2] ]
 *
 *
 * Example Explanation
 *
 * Out of all the possible triplets having total sum zero,only the above two triplets are unique.
 */
public class ThreeSumZero {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        int n = A.size();
        //Sort the ArrayList
        A.sort((a,b)->a.compareTo(b));
        //Map to store the triplets
        //Tree Map is used to maintain the order
        Map<Integer, Map<Integer,Integer>> resultMap = new TreeMap<>();
        //Fixing the first element and then searching for the pair
        for(int k=0;k<n;k++){
            int i = k+1;
            int j = n-1;
            int b = 0 - A.get(k);
            while(i<j){
                int sum = A.get(i) + A.get(j);
                if(sum > b){
                    j--;
                }else if(sum < b){
                    i++;
                }else {
                    if(resultMap.containsKey(A.get(k))){
                        Map<Integer,Integer> tempMap = resultMap.get(A.get(k));
                        tempMap.put(A.get(i),A.get(j));
                        resultMap.put(A.get(k),tempMap);
                    }else{
                        Map<Integer,Integer> tempMap = new TreeMap<>();
                        tempMap.put(A.get(i),A.get(j));
                        resultMap.put(A.get(k),tempMap);
                    }
                    i++;j--;
                }
            }
        }
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        for(Integer key : resultMap.keySet()){
            for(Integer innerKey : resultMap.get(key).keySet()){
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(0,key);
                tempList.add(1,innerKey);
                tempList.add(2,resultMap.get(key).get(innerKey));
                resultList.add(tempList);
            }
        }
        return resultList;
    }
}
