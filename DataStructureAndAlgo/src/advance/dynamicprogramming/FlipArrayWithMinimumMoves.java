package advance.dynamicprogramming;

import java.util.List;

/**
 *
 * Flip Array
 *
 * Problem Description
 *
 * Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).
 *
 * Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length of(A) <= 100
 *
 * Sum of all the elements will not exceed 10,000.
 *
 *
 *
 * Input Format
 *
 * First and only argument is an integer array A.
 *
 *
 *
 * Output Format
 *
 * Return an integer denoting the minimum number of elements whose sign needs to be flipped.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [15, 10, 6]
 * Input 2:
 *
 *  A = [14, 10, 4]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Here, we will flip the sign of 15 and the resultant sum will be 1.
 * Explanation 2:
 *
 *  Here, we will flip the sign of 14 and the resultant sum will be 0.
 *  Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there sign are not minimum.
 */
public class FlipArrayWithMinimumMoves {
    class FlipArray{
        int sum;
        int items;
        FlipArray(int sum,int items){
            this.sum = sum;
            this.items = items;
        }
    }
    public int solve(final List<Integer> A) {
        int sum = 0;
        for(int i=0;i<A.size();i++){
            sum = sum + A.get(i);
        }
        // sum = sum/2;

        FlipArray[][] dp = new FlipArray[A.size()+1][(sum/2)+1];

        //initialize the first row and colum
        for(int i=0;i<=A.size();i++){
            for(int j=0;j<=sum/2;j++){
                dp[i][j] = new FlipArray(0,0);
            }
        }



        int[] B =  new int[A.size()+1];

        B[0] = 0;
        for(int i=0;i<A.size();i++){
            B[i+1] = A.get(i);
        }

        for(int i=1;i<=A.size();i++){
            for(int j=1;j<=sum/2;j++){
                //since A is 0 based index
                if(B[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    FlipArray include = new FlipArray(B[i]+dp[i-1][j-B[i]].sum,1+dp[i-1][j-B[i]].items);
                    FlipArray exclude = dp[i-1][j];

                    dp[i][j] = compare(exclude,include);
                }
            }
        }

        return dp[A.size()][(sum/2)].items;
    }

    public FlipArray compare(FlipArray f1, FlipArray f2){
        if(f1.sum == f2.sum){
            return f1.items < f2.items ? f1 : f2;
        }else{
            return f1.sum > f2.sum ? f1 : f2;
        }
    }
}
