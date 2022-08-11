package advance.bitmanipulation;

/**
 *
 * Greatest Common Divisor
 *
 * Problem Description
 * Given 2 non-negative integers A and B, find gcd(A, B)
 *
 * GCD of 2 integers A and B is defined as the greatest integer 'g' such that 'g' is a divisor of both A and B. Both A and B fit in a 32 bit signed integer.
 *
 * Note: DO NOT USE LIBRARY FUNCTIONS.
 *
 *
 *
 * Problem Constraints
 * 0 <= A, B <= 109
 *
 *
 *
 * Input Format
 * First argument is an integer A.
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the gcd(A, B).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 4
 * B = 6
 * Input 2:
 *
 * A = 6
 * B = 7
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  2 divides both 4 and 6
 * Explanation 2:
 *
 *  1 divides both 6 and 7
 */
public class GreatestCommonDivisor {

    public int gcd(int A, int B) {
        //first find the smallest no.
        //find the factors of the numbers
        //and then check if the other no is divisible by the factores of the numbers.
        if(B==0) return A;

        int x = A>B ? B:A;
        int y = A>B ? A:B;
        int ans = 1;

        for(int i=1;i*i<=x;i++){
            if(x%i == 0 ){

                if(y%i == 0){
                    ans = i > ans ? i : ans;
                }
                if(y%(x/i) == 0){
                    ans = (x/i) > ans ? x/i : ans;
                }
            }
        }

        return ans;
    }
}
