package advance.sorting;

import java.util.ArrayList;

/**
 *  B Closest Points to Origin
 *
 *  Problem Description
 * We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
 *
 * Here, the distance between two points on a plane is the Euclidean distance.
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).
 *
 *
 *
 * Problem Constraints
 * 1 <= B <= length of the list A <= 105
 * -105 <= A[i][0] <= 105
 * -105 <= A[i][1] <= 105
 *
 *
 *
 * Input Format
 * The argument given is list A and an integer B.
 *
 *
 *
 * Output Format
 * Return the B closest points to the origin (0, 0) in any order.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *        [1, 3],
 *        [-2, 2]
 *      ]
 *  B = 1
 * Input 2:
 *
 *  A = [
 *        [1, -1],
 *        [2, -1]
 *      ]
 *  B = 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  [ [-2, 2] ]
 * Output 2:
 *
 *  [ [1, -1] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 *  So one closest point will be [-2,2].
 * Explanation 2:
 *
 *  The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 *  So one closest point will be [1,-1].
 */
public class BClosestToOriginUsingQuickSort {

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        //Quick Sort to Sort the array based on Distance
        quickSort(A,0,A.size()-1);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<B;i++){
            result.add(A.get(i));
        }

        return result;
    }

    public void quickSort(ArrayList<ArrayList<Integer>> A, int l,int r){
        if(l>r){
            return;
        }
        int index = rearrange(A,l,r);
        quickSort(A,l,index-1);
        quickSort(A,index+1,r);
    }

    //Implement Quick Sort
    public int rearrange (ArrayList<ArrayList<Integer>> A, int l,int r) {
        ArrayList<Integer> pivot = A.get(l);
        double pivotDistance = Math.pow(pivot.get(0),2) + Math.pow(pivot.get(1),2);
        int i=l+1;
        int j=r;

        while(i<=j){
            double iDistance = Math.pow(A.get(i).get(0),2) + Math.pow(A.get(i).get(1),2);
            double jDistance = Math.pow(A.get(j).get(0),2) + Math.pow(A.get(j).get(1),2);
            if(iDistance<=pivotDistance){
                i++;
            }else if(jDistance>pivotDistance){
                j--;
            }else{
                swap(A,i,j);
                i++;
                j--;
            }
        }
        swap(A,i-1,l);
        return i-1;

    }

    public void swap(ArrayList<ArrayList<Integer>> A, int i, int j){
        ArrayList<Integer> temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);
    }
}
