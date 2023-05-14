package advance.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Perfect Numbers
 *
 * Problem Description
 * Given an integer A, you have to find the Ath Perfect Number.
 *
 * A Perfect Number has the following properties:
 *
 * It comprises only 1 and 2.
 *
 * The number of digits in a Perfect number is even.
 *
 * It is a palindrome number.
 *
 * For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 100000
 *
 *
 *
 * Input Format
 * The only argument given is an integer A.
 *
 *
 *
 * Output Format
 * Return a string that denotes the Ath Perfect Number.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 2
 * Input 2:
 *
 *  A = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  22
 * Output 2:
 *
 *  1111
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 * Explanation 2:
 *
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 */
public class PerfectNumbers {
    public String solve(int A) {
        if(A == 1){
            return "11";
        }else if(A == 2){
            return "22";
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        int count = 2;
        String ans = "";
        while(true){
            String x = queue.remove();
            String newElement1 =  x + "1";
            String newElement2 =  x + "2";
            count++;
            if(count == A){
                ans = newElement1;
                break;
            }else{
                queue.add(newElement1);
            }
            count++;
            if(count == A){
                ans = newElement2;
                break;
            }else{
                queue.add(newElement2);
            }
        }

        StringBuilder finalResult = new StringBuilder();
        finalResult.append(ans);
        for(int i=ans.length()-1;i>=0;i--){
            finalResult.append(ans.charAt(i));
        }
        return finalResult.toString();
    }
}
