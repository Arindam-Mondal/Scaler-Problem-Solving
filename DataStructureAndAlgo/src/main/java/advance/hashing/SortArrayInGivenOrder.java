package advance.hashing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *  Sort Array in given Order
 *
 *  Problem Description
 * Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
 * For the elements not present in B, append them at last in sorted order.
 *
 * Return the array A after sorting from the above method.
 *
 * NOTE: Elements of B are unique.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array A <= 100000
 *
 * 1 <= length of the array B <= 100000
 *
 * -10^9 <= A[i] <= 10^9
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is the integer array B.
 *
 *
 *
 * Output Format
 * Return the array A after sorting as described.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * B = [5, 4, 2]
 * Input 2:
 *
 * A = [5, 17, 100, 11]
 * B = [1, 100]
 *
 *
 * Example Output
 * Output 1:
 *
 * [5, 4, 2, 1, 3]
 * Output 2:
 *
 * [100, 5, 11, 17]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Simply sort as described.
 * Explanation 2:
 *
 *  Simply sort as described.
 */
public class SortArrayInGivenOrder {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        //First Sort the list ArrayList A
        A.sort((a,b)->a.compareTo(b));
        int n = A.size();
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<n;i++){
            //Insert into the HashMap along count.
            int num = A.get(i);
            if(frequencyMap.containsKey(num)){
                int frequency = frequencyMap.get(num);
                frequencyMap.put(num,frequency+1);
            }else{
                frequencyMap.put(num,1);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int nB = B.size();
        for(int i=0;i<nB;i++){
            int num = B.get(i);
            if(frequencyMap.containsKey(num)){
                int count = frequencyMap.get(num);
                while(count>0){
                    result.add(num);
                    count--;
                }
                frequencyMap.remove(num);
            }
        }

        for(int i=0;i<n;i++){
            int num = A.get(i);
            if(frequencyMap.containsKey(num)){
                result.add(num);
            }
        }

        return result;
    }
}
