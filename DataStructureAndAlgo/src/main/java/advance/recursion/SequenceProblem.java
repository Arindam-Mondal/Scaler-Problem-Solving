package advance.recursion;

/**
 * Another sequence problem
 *
 * Problem Description
 * Given a sequence f(A) = f(A-1) + f(A-2) + f(A-3) + A . Calculate the Ath term of the sequence.
 *
 * Given f(0)=1; f(1)=1; f(2)=2;
 *
 *
 *
 * Problem Constraints
 * 0<=n<=20
 *
 *
 *
 * Input Format
 * First and only argument is an integer A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the Ath term of the sequence.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  3
 * Input 2:
 *
 *  2
 *
 *
 * Example Output
 * Output 1:
 *
 *  7
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  f(3) = 2+1+1+3 = 7
 * Explanation 2:
 *
 *  f(2) = 2 as given.
 */
public class SequenceProblem {
    public int solve(int A) {
        int[] memo = new int[A+1];
        if(A==0){
            memo[0] = 1;
        }else if(A==1){
            memo[0] = 1;
            memo[1] = 1;
        }else{
            memo[0] = 1;
            memo[1] = 1;
            memo[2] = 2;
        }

        // for(int i=0;i<memo.length;i++){
        //     System.out.println(memo[i]);
        // }

        if(A<3) {
            return memo[A];
        }else {
            populateMemo(memo,A);
            return memo[A];
        }

    }

    public int populateMemo(int[] memo,int A){
        // System.out.println(A);
        if(memo[A]!=0){
            return memo[A];
        }
        memo[A] = A + populateMemo(memo,A-1) + populateMemo(memo,A-2) + populateMemo(memo,A-3);
        return memo[A];
    }
}
