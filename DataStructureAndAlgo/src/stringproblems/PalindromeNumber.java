package stringproblems;

import java.util.ArrayList;

/**
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 *
 * Follow up: Could you solve it without converting the integer to a string?
 *
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x == 0) return true;
        if(x<0 || x%10 == 0) return false;

        String s = String.valueOf(x);
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i) !=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    //Without conversion to string
    public boolean isPalindromeWithoutConversion(int x) {
        if(x == 0) return true;
        if(x<0 || x%10 == 0) return false;
        int  o = x;
        ArrayList<Integer> list = new ArrayList<>();
        while(x>0){
            list.add(x%10);
            x = x/10;
        }
        int sum = 0;
        for(int i=0;i<list.size();i++){
            sum = sum + list.get(i) * (int)Math.pow(10,list.size()-i-1);
        }
        return sum == o;
    }
}
