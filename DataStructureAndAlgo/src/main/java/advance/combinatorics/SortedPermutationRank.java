package advance.combinatorics;

/**
 *  Sorted Permutation Rank
 *
 *  Problem Description
 * Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
 * Assume that no characters are repeated.
 *
 * Note: The answer might not fit in an integer, so return your answer % 1000003
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 1000
 *
 *
 *
 * Input Format
 * First argument is a string A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the rank of the given string.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = "acb"
 * Input 2:
 *
 * A = "a"
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Given A = "acb".
 * The order permutations with letters 'a', 'c', and 'b' :
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * So, the rank of A is 2.
 * Explanation 2:
 *
 * Given A = "a".
 * Rank is clearly 1.
 */
public class SortedPermutationRank {
    public int findRank(String A) {
        int fact[] = new int[A.length()+1];
        int mod = 1000003;
        fact[0]=1;
        fact[1]=1;
        for(int i=2;i<fact.length;i++){
            fact[i] = (i%mod * fact[i-1]%mod)%mod;
        }
        int rank = 1;

        for(int i=0;i<A.length();i++){
            int count =0;
            for(int j=i+1;j<A.length();j++){
                if(A.charAt(j)<A.charAt(i)){
                    count++;
                }
            }
            rank = (rank%mod + (count%mod * fact[A.length()-i-1]%mod)%mod)%mod;
        }

        return rank;
    }
}
