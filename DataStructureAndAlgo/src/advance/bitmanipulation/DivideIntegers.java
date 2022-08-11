package advance.bitmanipulation;

/**
 * Divide Integers
 *
 * Problem Description
 * Divide two integers without using multiplication, division and mod operator.
 *
 * Return the floor of the result of the division.
 *
 * Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.
 *
 * NOTE: INT_MAX = 2^31 - 1
 *
 *
 *
 * Problem Constraints
 * -231 <= A, B <= 231-1
 *
 * B != 0
 *
 *
 *
 * Input Format
 * The first argument is an integer A denoting the dividend.
 * The second argument is an integer B denoting the divisor.
 *
 *
 *
 * Output Format
 * Return an integer denoting the floor value of the division.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 5
 *  B = 2
 * Input 2:
 *
 *  A = 7
 *  B = 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  7
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  floor(5/2) = 2
 *
 */
public class DivideIntegers {
    public int divide(int A, int B) {
        if(A==0) return 0;
        long m = A;
        long n = B;
        long ans = 0;
        boolean sign = false;
        if(m<0){
            sign = !sign;
        }
        if(n<0) {
            sign = !sign;
        }

        m = Math.abs(m);
        n = Math.abs(n);

        for(int i=31;i>=0;i--){
            if((n * (1L<<i)) <= m){
                ans = ans + (1L<<i);
                m = m-(n* (1L<<i));
            }
        }

        if(sign){
            ans = ans * -1;
        }

        if(!sign && ans> Integer.MAX_VALUE){
            ans = Integer.MAX_VALUE;
        }

        return (int)ans;
    }
}
