package advance.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * First non-repeating character
 *
 * Problem Description
 * Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
 * B is formed such that we have to find the first non-repeating character each time a character is inserted to the stream and append it at the end to B. If no non-repeating character is found, append '#' at the end of B.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 *
 *
 * Input Format
 * The only argument given is string A.
 *
 *
 *
 * Output Format
 * Return a string B after processing the stream of lowercase alphabets A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abadbc"
 * Input 2:
 *
 *  A = "abcabc"
 *
 *
 * Example Output
 * Output 1:
 *
 * "aabbdd"
 * Output 2:
 *
 * "aaabc#"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * "a"      -   first non repeating character 'a'
 * "ab"     -   first non repeating character 'a'
 * "aba"    -   first non repeating character 'b'
 * "abad"   -   first non repeating character 'b'
 * "abadb"  -   first non repeating character 'd'
 * "abadbc" -   first non repeating character 'd'
 * Explanation 2:
 *
 * "a"      -   first non repeating character 'a'
 * "ab"     -   first non repeating character 'a'
 * "abc"    -   first non repeating character 'a'
 * "abca"   -   first non repeating character 'b'
 * "abcab"  -   first non repeating character 'c'
 * "abcabc" -   no non repeating character so '#'
 */
public class FirstNonRepeatingCharater {
    public String solve(String A) {
        Queue<Character> queue = new LinkedList<>();
        HashMap<Character,Integer> fm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int n = A.length();
        for(int i=0;i<n;i++){
            char c = A.charAt(i);
            if(fm.containsKey(c)){
                fm.put(c,2);
            }else{
                fm.put(c,1);
                queue.add(c);
            }

            while(!queue.isEmpty() && fm.get(queue.peek()) > 1){
                queue.poll();
            }

            if(!queue.isEmpty()){
                sb.append(queue.peek());
            }else{
                sb.append('#');
            }
        }
        return sb.toString();
    }
}
