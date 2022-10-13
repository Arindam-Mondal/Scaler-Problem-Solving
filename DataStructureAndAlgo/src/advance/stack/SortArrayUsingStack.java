package advance.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * Sort stack using another stack
 *
 * Problem Description
 * Given a stack of integers A, sort it using another stack.
 *
 * Return the array of integers after sorting the stack using another stack.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 5000
 *
 * 0 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument is a stack given as an integer array A.
 *
 *
 *
 * Output Format
 * Return the array of integers after sorting the stack using another stack.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [5, 4, 3, 2, 1]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 2, 3, 4, 5]
 * Output 2:
 *
 *  [5, 11, 17, 100]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Just sort the given numbers.
 * Explanation 2:
 *
 *  Just sort the given numbers.
 */
public class SortArrayUsingStack {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> main = new Stack<>();
        Stack<Integer> helper = new Stack<>();
        int n = A.size();
        main.push(A.get(0));
        for(int i=1;i<n;i++){
            int temp = A.get(i);
            while(!main.empty() && temp> main.peek()){
                helper.push(main.pop());
            }
            main.push(temp);
            while(!helper.empty()){
                main.push(helper.pop());
            }
        }
        while(!main.empty()){
            helper.push(main.pop());
        }
        ArrayList<Integer> result = new ArrayList<>();
        Iterator<Integer> itr = helper.iterator();
        while(itr.hasNext()){
            result.add(itr.next());
        }
        return result;
    }
}
