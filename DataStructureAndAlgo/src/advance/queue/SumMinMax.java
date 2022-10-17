package advance.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Sum of min and max
 *
 * Ask for help from a TA and get it resolved.
 * Get help from TA.
 * Problem Description
 * Given an array A of both positive and negative integers.
 *
 * Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
 *
 * NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of array A <= 105
 *
 * -109 <= A[i] <= 109
 *
 * 1 <= B <= size of array
 *
 *
 *
 * Input Format
 * The first argument denotes the integer array A.
 * The second argument denotes the value B
 *
 *
 *
 * Output Format
 * Return an integer that denotes the required value.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 5, -1, 7, -3, -1, -2]
 *  B = 4
 * Input 2:
 *
 *  A = [2, -1, 3]
 *  B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  18
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Subarrays of size 4 are :
 *     [2, 5, -1, 7],   min + max = -1 + 7 = 6
 *     [5, -1, 7, -3],  min + max = -3 + 7 = 4
 *     [-1, 7, -3, -1], min + max = -3 + 7 = 4
 *     [7, -3, -1, -2], min + max = -3 + 7 = 4
 *     Sum of all min & max = 6 + 4 + 4 + 4 = 18
 * Explanation 2:
 *
 *  Subarrays of size 2 are :
 *     [2, -1],   min + max = -1 + 2 = 1
 *     [-1, 3],   min + max = -1 + 3 = 2
 *     Sum of all min & max = 1 + 2 = 3
 */
public class SumMinMax {
    public int solve(ArrayList<Integer> A, int B) {
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        int n = A.size();

        for(int i=0;i<B;i++){
            int num = A.get(i);
            if(min.isEmpty()){
                min.addLast(num);
            }else{
                while(!min.isEmpty() && num < min.peekLast()){
                    min.removeLast();
                }
                min.addLast(num);
            }

            if(max.isEmpty()){
                max.addLast(num);
            }else{
                while(!max.isEmpty() && num > max.peekLast()){
                    max.removeLast();
                }
                max.addLast(num);
            }
        }
        long sum = 0;
        int mod = 1000000007;
        for(int i=1;i<=n-B;i++){
            // System.out.println(A.get(i)+" "+min+" "+max);
            sum = (sum + min.peekFirst()%mod + max.peekFirst()%mod + mod)%mod;
            int num = A.get(i+B-1);
            int prevNum = A.get(i-1);
            if(prevNum == min.peekFirst()){
                min.removeFirst();
            }if(prevNum == max.peekFirst()){
                max.removeFirst();
            }

            if(min.isEmpty()){
                min.addLast(num);
            }else{
                while(!min.isEmpty() && num < min.peekLast()){
                    min.removeLast();
                }
                min.addLast(num);
            }

            if(max.isEmpty()){
                max.addLast(num);
            }else{
                while(!max.isEmpty() && num > max.peekLast()){
                    max.removeLast();
                }
                max.addLast(num);
            }
        }
        sum = (sum + min.peekFirst()%mod + max.peekFirst()%mod + mod)%mod;
        return (int)(sum);
    }
}
