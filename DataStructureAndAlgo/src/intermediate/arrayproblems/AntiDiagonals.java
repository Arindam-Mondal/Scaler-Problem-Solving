package intermediate.arrayproblems;

import java.util.ArrayList;

public class AntiDiagonals {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int S = A.get(0).size();
        ArrayList<ArrayList<Integer>> AD = new ArrayList<>();
        for(int i=0;i<S-1;i++){
            ArrayList<Integer> ADR = new ArrayList<>();
            int x = 0;
            int y=i;
            while(x<S && y>=0){
                ADR.add(A.get(x).get(y));
                x++;
                y--;
            }
            int ADRS = ADR.size();
            for(int k=0;k<S-ADRS;k++){
                ADR.add(0);
            }
            AD.add(ADR);
        }
        for(int j=0;j<S;j++){
            ArrayList<Integer> ADR = new ArrayList<>();
            int x = j;
            int y= S-1;
            while(x<S && y>=0){
                ADR.add(A.get(x).get(y));
                x++;
                y--;
            }
            int ADRS = ADR.size();
            for(int k=0;k<S-ADRS;k++){
                ADR.add(0);
            }
            AD.add(ADR);
        }
        return AD;
    }
}
