package advance.backtracking;

import java.util.ArrayList;

public class UniquePathsIII {
    int count = 0;
    public int solve(ArrayList<ArrayList<Integer>> A) {
        //first find the starting position and no of non-obstacles

        int rows = A.size();
        int columns = A.get(0).size();
        int nonObstacle = 0;
        int startRow = 0;
        int startCol = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(A.get(i).get(j) == 1){
                    startRow = i;
                    startCol = j;
                }else if(A.get(i).get(j) == 0){
                    nonObstacle++;
                }
            }
        }

        findPath(A,startRow,startCol,nonObstacle,-1);

        return count;

    }

    public void findPath(ArrayList<ArrayList<Integer>> A, int i,int j,int nonObstacle, int countObs){

        if(i<0 || i >= A.size() || j<0 || j>=A.get(0).size()){
            return;
        }

        if(A.get(i).get(j) == 2){

            if(nonObstacle==countObs){
                count++;
            }
            return;
        }

        if(A.get(i).get(j) == -1){
            return;
        }

        //traverse left
        A.get(i).set(j,-1);
        findPath(A,i,j-1,nonObstacle,countObs+1);
        findPath(A,i,j+1,nonObstacle,countObs+1);
        findPath(A,i+1,j,nonObstacle,countObs+1);
        findPath(A,i-1,j,nonObstacle,countObs+1);
        A.get(i).set(j,0);

    }
}
