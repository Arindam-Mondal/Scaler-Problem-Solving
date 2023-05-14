package advance.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * N max pair combinations
 *
 * Problem Description
 * Given two integers arrays, A and B, of size N each.
 *
 * Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in arrays A and B.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 2 * 105
 *
 * -1000 <= A[i], B[i] <= 1000
 *
 *
 *
 * Input Format
 * The first argument is an integer array A.
 * The second argument is an integer array B.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the N maximum element in descending order.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 4, 2, 3]
 *  B = [2, 5, 1, 6]
 * Input 2:
 *
 *  A = [2, 4, 1, 1]
 *  B = [-2, -3, 2, 4]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [10, 9, 9, 8]
 * Output 2:
 *
 *  [8, 6, 6, 5]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  4 maximum elements are 10(6+4), 9(6+3), 9(5+4), 8(6+2).
 * Explanation 2:
 *
 *  4 maximum elements are 8(4+4), 6(4+2), 6(4+2), 5(4+1).
 */
public class NMaxPairCombinations {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        A.sort(Collections.reverseOrder());
        B.sort(Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = A.size();
        for(int i=0;i<A.size();i++){
            for(int j=0;j<B.size();j++){
                int x = A.get(i) +B.get(j);
                if(pq.size() < n){
                    pq.add(x);
                }else if(pq.peek() < x){
                    pq.poll();
                    pq.offer(x);
                }else{
                    //Breaking as arrays are sorted and there cannot be any pair possible having sum greater than the previous pair.
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(pq.size()>0){
            result.add(pq.poll());
        }
        result.sort(Collections.reverseOrder());



        return result;

    }
}
