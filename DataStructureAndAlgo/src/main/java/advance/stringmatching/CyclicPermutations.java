package advance.stringmatching;

/**
 * Cyclic Permutations
 *
 * Problem Description
 * Given two binary strings A and B, count how many cyclic shift of B when taken XOR with A give 0.
 *
 * NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic shift is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.
 *
 *
 *
 * Problem Constraints
 * 1 ≤ length(A) = length(B) ≤ 105
 *
 *
 *
 * Input Format
 * The first argument is a string A.
 * The second argument is a string B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the required answer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "1001"
 *  B = "0011"
 * Input 2:
 *
 *  A = "111"
 *  B = "111"
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  4 cyclic shifts of B exists: "0011", "0110", "1100", "1001".
 *  There is only one cyclic shift of B i.e. "1001" which has 0 xor with A.
 * Explanation 2:
 *
 *  All cyclic shifts of B are same as A and give 0 when taken xor with A. So, the ans is 3.
 */
public class CyclicPermutations {
    public int solve(String A, String B) {
        String str = A + "$" + B + B.substring(0,B.length()-1);
        //Find Z Array
        int[] Z = new int[str.length()];
        calculateZArray(str,Z);
        int count = 0;
        for(int i = A.length(); i<Z.length;i++){
            if(Z[i] == A.length()){
                count++;
            }
        }
        return count;

    }

    public void calculateZArray(String str, int[] Z){
        int n = str.length();
        int left = 0, right = 0;
        for(int i=1;i<n;i++){
            if(i>right){
                left = right = i;
                while(right < n && str.charAt(right - left) == str.charAt(right)){
                    right++;
                }

                Z[i] = right - left;
                right--;
            }else{
                int k = i - left;
                if(Z[k]<right-i+1){
                    Z[i] = Z[k];
                }else{
                    left=i;
                    while(right<n && str.charAt(right-left)==str.charAt(right)){
                        right++;
                    }
                    Z[i] = right -left;
                    right--;
                }
            }
        }
    }
}
