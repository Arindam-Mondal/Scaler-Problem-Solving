package advance.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Largest Number
 *
 * Problem Description
 * Given an array A of non-negative integers, arrange them such that they form the largest number.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 *
 *
 * Problem Constraints
 * 1 <= len(A) <= 100000
 * 0 <= A[i] <= 2*109
 *
 *
 *
 * Input Format
 * The first argument is an array of integers.
 *
 *
 *
 * Output Format
 * Return a string representing the largest number.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 30, 34, 5, 9]
 * Input 2:
 *
 *  A = [2, 3, 9, 0]
 *
 *
 * Example Output
 * Output 1:
 *
 *  "9534330"
 * Output 2:
 *
 *  "9320"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
 * Explanation 2:
 *
 * Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */
public class LargestNumberUsingCustomComparator {

    public String largestNumber(final List<Integer> A) {
        ArrayList<String> stringList = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            stringList.add(Integer.toString(A.get(i)));
        }

        stringList.sort((a,b)->{return (b+a).compareTo(a+b);});

        String result = "";
        int i=0;
        while(i<stringList.size()-1){
            if(!stringList.get(i).equals("0")){
                break;
            }
            i++;
        }
        for(;i<stringList.size();i++){
            result = result + stringList.get(i);
        }

        return result;
    }

}
