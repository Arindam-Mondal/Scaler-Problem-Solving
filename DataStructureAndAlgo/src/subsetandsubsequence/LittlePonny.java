package subsetandsubsequence;

/**
 * Little Ponny and 2-Subsequence
 *
 * Problem Description
 *
 * Little Ponny has been given a string A, and he wants to find out the lexicographically minimum subsequence from it of size >= 2. Can you help him?
 *
 * A string a is lexicographically smaller than string b, if the first different letter in a and b is smaller in a. For example, "abc" is lexicographically smaller than "acc" because the first different letter is 'b' and 'c' which is smaller in "abc".
 *
 *
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 105
 *
 * A only contains lowercase alphabets.
 *
 *
 *
 * Input Format
 *
 * The first and the only argument of input contains the string, A.
 *
 *
 *
 * Output Format
 *
 * Return a string representing the answer.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = "abcdsfhjagj"
 * Input 2:
 *
 *  A = "ksdjgha"
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  "aa"
 * Output 2:
 *
 *  "da"
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  "aa" is the lexicographically minimum subsequence from A.
 * Explanation 2:
 *
 *  "da" is the lexicographically minimum subsequence from A.
 */
public class LittlePonny {

    public String solve(String A) {
        int n = A.length();
        char s1 = A.charAt(n-2);
        char s2 = A.charAt(n-1);
        for(int i=n-3;i>=0;i--){
            if(A.charAt(i)<=s1){
                if(s1<=s2){
                    s2 = s1;
                    s1 = A.charAt(i);
                }else{
                    s1 = A.charAt(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }
}
