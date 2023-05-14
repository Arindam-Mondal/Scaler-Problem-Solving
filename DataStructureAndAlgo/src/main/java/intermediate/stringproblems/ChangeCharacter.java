package intermediate.stringproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Change character
 * Problem Description
 * You are given a string A of size N consisting of lowercase alphabets.
 *
 * You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
 *
 * Find the minimum number of distinct characters in the resulting string.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 100000
 *
 * 0 <= B < N
 *
 *
 *
 * Input Format
 * The first argument is a string A.
 *
 * The second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the minimum number of distinct characters in the string.
 *
 *
 *
 * Example Input
 * A = "abcabbccd"
 * B = 3
 *
 *
 *
 * Example Output
 * 2
 *
 *
 *
 * Example Explanation
 * We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
 * So the minimum number of distinct character will be 2.
 */
public class ChangeCharacter {
    public int solve(String A, int B) {
        Map<Character,Integer> fm = new HashMap<>();
        for(int i=0;i<A.length();i++){
            char c = A.charAt(i);
            if(fm.containsKey(c)){
                fm.put(c,fm.get(c)+1);
            }else {
                fm.put(c,1);
            }
        }
        ArrayList<Integer> values = new ArrayList<>(fm.values());
        values.sort((a,b) -> a.compareTo(b));
        int size = values.size();
        int i=0;
        while(B>0){
            B = B - values.get(i);
            if(B>=0){
                size--;
            }
            i++;
        }
        return size;
    }
}
