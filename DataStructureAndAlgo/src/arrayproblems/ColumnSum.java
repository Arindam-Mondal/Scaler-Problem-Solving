package arrayproblems;

import java.util.ArrayList;

public class ColumnSum {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<m;i++){
            int sum = 0;
            for(int j=0;j<n;j++){
                sum = sum + A.get(j).get(i);
            }
            result.add(sum);
        }
        return result;
    }
}
