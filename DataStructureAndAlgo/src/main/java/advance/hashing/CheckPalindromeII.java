package advance.hashing;

import java.util.HashMap;
import java.util.Map;

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
public class CheckPalindromeII {

    public int solve(String A) {
        //Top rearrange the characters of A to be palindrome - if length of A is odd only one character can have odd frequency and rest has to have even frequenecy.
        //If length of a is even then all the charactrs has to have a even frequency.
        int count = 0;
        //Create a frequency Map
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<A.length();i++){
            char c = A.charAt(i);
            if(frequencyMap.containsKey(c)){
                int frequency = frequencyMap.get(c);
                frequencyMap.put(c,frequency+1);
            }else{
                frequencyMap.put(c,1);
            }
            count++;
        }

        int eventCount = 0;
        int oddCount = 0;

        for(Character c : frequencyMap.keySet()){
            int frequency = frequencyMap.get(c);
            if(frequency%2==0){
                eventCount++;
            }else{
                oddCount++;
            }
            if(oddCount>1 || (count%2 == 0 && oddCount > 0)){
                return 0;
            }
        }
        return 1;
    }
}
