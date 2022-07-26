package advance.arrays;

import java.util.ArrayList;

/**
 * Problem Description
 * Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :
 *
 * Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
 * A: For the purpose of this question, YES
 * Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
 * A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 *
 *
 * Problem Constraints
 * 1 <= size of the array <= 1000000
 *
 *
 *
 * Input Format
 * First argument is an array of digits.
 *
 *
 *
 * Output Format
 * Return the array of digits after adding one.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * [1, 2, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 * [1, 2, 4]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Given vector is [1, 2, 3].
 * The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */
public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> temp = new ArrayList<>();
        int carry = 1;
        int start = 0;
        int n = A.size();
        while(start < n && A.get(start) == 0){
            start++;
        }
        if(start == n){
            temp.add(1);
            return temp;
        }
        for(int i=n-1;i>=start;i--){
            int sum = A.get(i) + carry;
            carry = 0;
            if(sum > 9){
                carry = sum - 9;
                sum = sum % 10;
            }
            temp.add(sum);
        }
        if(carry > 0){
            temp.add(carry);
        }
        int j=0;
        int k=temp.size()-1;
        while(j<k){
            int x = temp.get(j);
            int y = temp.get(k);
            temp.set(j,y);
            temp.set(k,x);
            j++;
            k--;
        }
        return temp;
    }
}
