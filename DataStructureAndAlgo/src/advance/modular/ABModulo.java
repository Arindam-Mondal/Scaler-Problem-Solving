package advance.modular;

/**
 * Problem Description
 * Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.
 *
 *
 *
 * Problem Constraints
 * 1 <= A, B <= 109
 * A != B
 *
 *
 *
 * Input Format
 * The first argument is an integer A.
 * The second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the greatest possible positive M.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 1
 * B = 2
 * Input 2:
 *
 * A = 5
 * B = 10
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 5
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * 1 is the largest value of M such that A % M == B % M.
 * Explanation 2:
 *
 * For M = 5, A % M = 0 and B % M = 0.
 *
 * No value greater than M = 5, satisfies the condition.
 */
public class ABModulo {
    //A % M = B % M.
    //=> A % M - B% M = 0
    //Adding M on the both side
    //=> A%M - B%M + M = M
    //Taking Mod on both side
    //=> (A%M - B%M + M) % M = M % M
    //=> (A-B)%M = 0
    //This implies to M should be a factor of A-B for (A-B)%M to become 0
    public int solve(int A, int B) {
        int diff = Math.abs(A-B);
        int m = 0;
        // System.out.println(diff);
        for(int i=1;i*i<diff;i++){
            if(diff % i == 0){
                m = diff/i;
                break;
            }
        }
        return m;
    }
}
