package hashing;

import java.util.HashMap;

/**
 * Check Palindrome - II
 *
 * Problem Description
 * Given a string A consisting of lowercase characters.
 *
 * Check if characters of the given string can be rearranged to form a palindrome.
 *
 * Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 *
 * A consists only of lower-case characters.
 *
 *
 *
 * Input Format
 * First argument is an string A.
 *
 *
 *
 * Output Format
 * Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abcde"
 * Input 2:
 *
 *  A = "abbaee"
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  No possible rearrangement to make the string palindrome.
 * Explanation 2:
 *
 *  Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.
 */
public class CheckPalindrome {
    public int solve(String A) {
        HashMap<Character,Integer> fm = new HashMap<>();
        int fo = 0;
        for(int i=0;i<A.length();i++){
            if(fm.containsKey(A.charAt(i))){
                fm.put(A.charAt(i),fm.get(A.charAt(i))+1);
            }else{
                fm.put(A.charAt(i),1);
            }
        }
        for(int value:fm.values()){
            if(value % 2 !=0){
                fo++;
            }

            if(fo>1){
                return 0;
            }
        }

        return 1;
    }
}
