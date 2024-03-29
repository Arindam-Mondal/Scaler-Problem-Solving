package advance.stringmatching;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeat
 *
 * Problem Description
 * Given a string A, find the length of the longest substring without repeating characters.
 *
 * Note: Users are expected to solve in O(N) time complexity.
 *
 *
 *
 * Problem Constraints
 * 1 <= size(A) <= 106
 *
 * String consists of lowerCase,upperCase characters and digits are also present in the string A.
 *
 *
 *
 * Input Format
 * Single Argument representing string A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum possible length of substring without repeating characters.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abcabcbb"
 * Input 2:
 *
 *  A = "AaaA"
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Substring "abc" is the longest substring without repeating characters in string A.
 * Explanation 2:
 *
 *  Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
 */
public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {
        int l = 0;
        int r = 0;
        int n = A.length();
        Set<Character> charSet = new HashSet<>();
        int result = 0;
        while(r<n){
            if(charSet.contains(A.charAt(r))){
                while(l<r && A.charAt(l) != A.charAt(r)){
                    charSet.remove(A.charAt(l));
                    l++;
                }
                charSet.remove(A.charAt(l));
                l++;
            }
            charSet.add(A.charAt(r));
            result = Math.max(result,(r-l+1));
            r++;
        }
        return result;
    }
}
