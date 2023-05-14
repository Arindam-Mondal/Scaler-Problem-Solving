package intermediate.arrayproblems;

import java.util.ArrayList;

/**
 * Problem Description
 * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 1000
 *
 *
 *
 * Input Format
 * First and only argument is integer A
 *
 *
 * Output Format
 * Return a 2-D matrix which consists of the elements in spiral order.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * 1
 * Input 2:
 *
 * 2
 *
 *
 * Example Output
 * Output 1:
 *
 * [ [1] ]
 * Output 2:
 *
 * [ [1, 2], [4, 3] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *
 * Only 1 is to be arranged.
 * Explanation 2:
 *
 * 1 --> 2
 *       |
 *       |
 * 4<--- 3
 */
public class SpiralOrderMatrixII {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int k = 0;
        int m = A;
        int l = 0;
        int n = A;
        int value = 1;
        ArrayList<ArrayList<Integer>> R = new ArrayList<>();
        for(int i=0;i<m;i++){
            ArrayList<Integer> rows = new ArrayList<>();
            for(int j=0;j<n;j++){
                rows.add(0);
            }
            R.add(rows);
        }
        while(k<m && l<n){
            //traverse the first row
            for(int i=l;i<n;i++){
                R.get(k).set(i,value++);
            }
            k++;
            //traverse the last column
            for(int i=k;i<m;i++){
                R.get(i).set(n-1,value++);
            }
            n--;
            //traverse last row
            if(k<m){
                for(int i=n-1;i>=l;i--){
                    R.get(m-1).set(i,value++);
                }
                m--;
            }
            //traverse first column
            if(l<n){
                for(int i=m-1;i>=k;i--){
                    R.get(i).set(l,value++);
                }
                l++;
            }
        }
        return R;
    }
}
