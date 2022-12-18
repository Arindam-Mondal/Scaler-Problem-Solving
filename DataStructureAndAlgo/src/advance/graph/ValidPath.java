package advance.graph;

import java.util.ArrayList;

/**
 *  Valid Path
 *
 * Problem Description
 * There is a rectangle with left bottom as (0, 0) and right up as (x, y).
 *
 * There are N circles such that their centers are inside the rectangle.
 *
 * Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
 *
 * Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.
 *
 *
 *
 * Problem Constraints
 * 0 <= x , y, R <= 100
 *
 * 1 <= N <= 1000
 *
 * Center of each circle would lie within the grid
 *
 *
 *
 * Input Format
 * 1st argument given is an Integer x , denoted by A in input.
 *
 * 2nd argument given is an Integer y, denoted by B in input.
 *
 * 3rd argument given is an Integer N, number of circles, denoted by C in input.
 *
 * 4th argument given is an Integer R, radius of each circle, denoted by D in input.
 *
 * 5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle
 *
 * 6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle
 *
 *
 *
 * Output Format
 * Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  x = 2
 *  y = 3
 *  N = 1
 *  R = 1
 *  A = [2]
 *  B = [3]
 * Input 2:
 *
 *  x = 1
 *  y = 1
 *  N = 1
 *  R = 1
 *  A = [1]
 *  B = [1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  NO
 * Output 2:
 *
 *  NO
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There is NO valid path in this case
 * Explanation 2:
 *
 *  There is NO valid path in this case
 */
public class ValidPath {
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        //Create a 2D matrix with all the co-ordinates from 0,0 to A,B
        int[][] coordinates = new int[A+1][B+1];
        //Mark the coordinates if it lies inside the circle
        for(int i=0;i<=A;i++){
            for(int j=0;j<=B;j++){
                validateCoordinate(coordinates,E,F,i,j,C,D);
            }
        }
        //Now will check if we can reach A,B from 0,0
        traverse(coordinates,0,0);
        return coordinates[A][B] == 2 ? "YES" : "NO";
    }
    public void validateCoordinate(int[][] coordinates,ArrayList<Integer> E,ArrayList<Integer> F,int i, int j,int C,int D){
        for(int k=0;k<C;k++){
            int x = E.get(k);
            int y = F.get(k);
            double rad = Math.sqrt(Math.pow(x-i,2) + Math.pow(y-j,2));
            if(rad<=D){
                //lies inside the circle
                coordinates[i][j] = 1;
                return;
            }
        }
    }

    public void traverse(int[][] coordinates,int i, int j){
        if(i<0 || i>=coordinates.length || j<0 || j>=coordinates[0].length){
            return;
        }
        if(coordinates[i][j] == 1 || coordinates[i][j] == 2){
            return;
        }
        //means visited
        coordinates[i][j] = 2;
        //traverse in all eight direction
        //left
        traverse(coordinates,i,j-1);
        //right
        traverse(coordinates,i,j+1);
        //top
        traverse(coordinates,i-1,j);
        //bottom
        traverse(coordinates,i+1,j);
        //leftbottomcorner
        traverse(coordinates,i+1,j-1);
        //rightbottomcorner
        traverse(coordinates,i+1,j+1);
        //lefttopcorner
        traverse(coordinates,i-1,j-1);
        //righttopcorner
        traverse(coordinates,i-1,j+1);
    }
}
