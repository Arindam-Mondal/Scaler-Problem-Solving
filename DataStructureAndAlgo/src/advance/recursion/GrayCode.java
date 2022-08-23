package advance.recursion;

import java.util.ArrayList;

/**
 * Problem Description
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
 *
 * A gray code sequence must begin with 0.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 16
 *
 *
 *
 * Input Format
 * The first argument is an integer A.
 *
 *
 *
 * Output Format
 * Return an array of integers representing the gray code sequence.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 2
 * Input 1:
 *
 * A = 1
 *
 *
 * Example Output
 * output 1:
 *
 * [0, 1, 3, 2]
 * output 2:
 *
 * [0, 1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * for A = 2 the gray code sequence is:
 *     00 - 0
 *     01 - 1
 *     11 - 3
 *     10 - 2
 * So, return [0,1,3,2].
 * Explanation 1:
 *
 * for A = 1 the gray code sequence is:
 *     00 - 0
 *     01 - 1
 * So, return [0, 1].
 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> result = new ArrayList<>();
        findGrayCode(a,result);
        return result;
    }

    public void findGrayCode(int a, ArrayList<Integer> grayList){
        if(a==1){
            grayList.add(0);
            grayList.add(1);
            return;
        }
        //find the graycode of n-1 bits and add to the list in reverse order and again need to add the most significant bit.
        findGrayCode(a-1,grayList);
        ArrayList<Integer> newGrayList = new ArrayList<>();
        for(int i=grayList.size()-1;i>=0;i--){
            newGrayList.add(grayList.get(i)+ (1<<a-1));
        }
        grayList.addAll(newGrayList);
    }
}
