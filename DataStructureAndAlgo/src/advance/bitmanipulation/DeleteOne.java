package advance.bitmanipulation;

import java.util.ArrayList;

/**
 * Delete one
 *
 * Problem Description
 *
 * Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
 *
 * Find the maximum value of GCD.
 *
 *
 *
 * Problem Constraints
 *
 * 2 <= N <= 105
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the maximum value of GCD.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [12, 15, 18]
 * Input 2:
 *
 *  A = [5, 15, 30]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  15
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *
 *  If you delete 12, gcd will be 3.
 *  If you delete 15, gcd will be 6.
 *  If you delete 18, gcd will 3.
 *  Maximum vallue of gcd is 6.
 * Explanation 2:
 *
 *  If you delete 5, gcd will be 15.
 *  If you delete 15, gcd will be 5.
 *  If you delete 30, gcd will be 5.
 */
public class DeleteOne {
    public int solve(ArrayList<Integer> A) {
        //calculate the suffix GCD - Right GCD
        //Calculate the prefix GCD - Left GCD
        //Calculate the GCD of Right GCD , Left GCD
        int[] rightGCD = new int[A.size()];
        int[] leftGCD = new int[A.size()];

        rightGCD[0] = A.get(0);
        leftGCD[A.size()-1] = A.get(A.size()-1);

        for(int i=1;i<A.size();i++){
            rightGCD[i] = findGCD(rightGCD[i-1], A.get(i));
        }
        for(int i=A.size()-2;i>=0;i--){
            leftGCD[i] = findGCD(A.get(i),leftGCD[i+1]);
        }
        int result = 0;
        for(int i=0;i<A.size();i++){
            if(i==0){
                result = Math.max(result,leftGCD[i+1]);
            }else if(i==A.size()-1){
                result = Math.max(result,rightGCD[i-1]);
            }else{
                result = Math.max(result,findGCD(rightGCD[i-1],leftGCD[i+1]));
            }

        }
        return result;

    }

    public int findGCD(int x, int y){
        int max = Math.max(x,y);
        int min = Math.min(x,y);
        int result = 0;
        //Find all the factors of min
        for(int i=1;i*i<=min;i++){
            if(min%i == 0){
                if(max%i == 0){
                    result = Math.max(i,result);
                }
                if(max%(min/i) == 0){
                    result = Math.max(min/i,result);
                }
            }

        }
        return result;
    }
}
