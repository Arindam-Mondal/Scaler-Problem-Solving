package advance.backtracking;

import java.util.ArrayList;

/**
 * Problem Description
 * Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
 *
 *
 *
 * A sudoku puzzle,
 *
 *
 *
 * and its solution numbers marked in red.
 *
 *
 *
 * Problem Constraints
 * N = 9
 *
 *
 * Input Format
 * First argument is an array of array of characters representing the Sudoku puzzle.
 *
 *
 * Output Format
 * Modify the given input to the required answer.
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
 *
 *
 * Example Output
 * Output 1:
 *
 * [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Look at the diagrams given in the question.
 */
public class Sudoku {
    public class Solution {
        public void solveSudoku(ArrayList<ArrayList<Character>> a) {
            solveSudoku(a,0,0);

        }

        public boolean solveSudoku(ArrayList<ArrayList<Character>> a, int row, int col) {
            int n = a.size();
            int m = a.get(0).size();

            if(row>=n){
                return true;
            }
            int nextCol = col+1 >= m ? 0 : col+1;
            int nextRow = col+1 >= m ? row+1 : row;

            if(a.get(row).get(col) != '.'){
                //check for the next cell
                return solveSudoku(a,nextRow,nextCol);
            }

            for(char c = '1'; c<='9';c++){
                if(isValid(a,row,col,c)){
                    a.get(row).set(col,c);
                    if(solveSudoku(a,nextRow,nextCol)){
                        return true;
                    }else{
                        //revert the row
                        a.get(row).set(col,'.');
                    }
                }
            }
            return false;
        }

        public boolean isValid(ArrayList<ArrayList<Character>> a, int row, int col,char c){
            int n = a.size();
            int m = a.get(0).size();
            //check in row
            for(int j=0;j<m;j++){
                if(a.get(row).get(j) == c){
                    return false;
                }
            }

            //check in column
            for(int i=0;i<n;i++){
                if(a.get(i).get(col)==c){
                    return false;
                }
            }

            //check in block
            int startRow = (row/3) * 3;
            int startCol = (col/3) * 3;

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(a.get(i+startRow).get(j+startCol) == c){
                        return false;
                    }
                }
            }

            return true;
        }

    }
}
