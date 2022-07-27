package advance.arrays;

import java.util.List;

/**
 * Problem Description
 * Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 *
 *
 * Input Format
 * First and only argument is the vector A
 *
 *
 *
 * Output Format
 * Return one integer, the answer to the question
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [0, 1, 0, 2]
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * 1 unit is trapped on top of the 3rd element.
 * Explanation 2:
 *
 * No water is trapped.
 */
public class RainWaterTrapped {

    public int trap(final List<Integer> A) {
        int n = A.size();
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int totalWaterTrapped = 0;
        if(A.size() <= 2) {
            return 0;
        }
        leftMax[0] = 0;
        for(int i=1;i<A.size();i++){
            leftMax[i] = Math.max(A.get(i-1),leftMax[i-1]);
            // leftMax.add();
        }

        rightMax[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(A.get(i+1),rightMax[i+1]);
        }

        for(int i = 0;i<n;i++){
            int waterTrapped = Math.min(leftMax[i],rightMax[i]) - A.get(i);
            totalWaterTrapped = waterTrapped > 0 ? totalWaterTrapped + waterTrapped : totalWaterTrapped;
        }

        return totalWaterTrapped;

    }
}
