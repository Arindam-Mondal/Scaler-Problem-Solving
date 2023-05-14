package advance.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Count Rectangles
 *
 * Problem Description
 * Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
 *
 * Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 2000
 * 0 <= A[i], B[i] <= 109
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 *
 *
 *
 * Output Format
 * Return the number of unordered quadruplets that form a rectangle.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 1, 2, 2]
 *  B = [1, 2, 1, 2]
 * Input 1:
 *
 *  A = [1, 1, 2, 2, 3, 3]
 *  B = [1, 2, 1, 2, 1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All four given points make a rectangle. So, the answer is 1.
 * Explanation 2:
 *
 *  3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
 *                                            (1, 1), (3, 1), (3, 2), (1, 2)
 *                                            (2, 1), (3, 1), (3, 2), (2, 2)
 */
public class CountRectangles {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        //store the coordinates in a store
        Set<String> coordinateSet = new HashSet<>();
        int n = A.size();
        int count = 0;
        for(int i=0;i<n;i++){
            String coordinate = A.get(i) + "-" + B.get(i);
            coordinateSet.add(coordinate);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int x1 = A.get(i);
                int y1 = B.get(i);
                int x2 = A.get(j);
                int y2 = B.get(j);
                if(x1 == x2 || y1 == y2){
                    continue;
                }
                String coordinate1 = x1 + "-" + y2;
                String coordinate2 = x2+ "-" + y1;

                if(coordinateSet.contains(coordinate1) && coordinateSet.contains(coordinate2)){
                    count++;
                }
            }
        }
        return count/4;
    }
}
