package ArrayProblems;

import java.util.ArrayList;

public class SubarrayWithLeastAverage {
}

class SubarrayWithLeastAverageSolution {
    public int solve(ArrayList<Integer> A, int B) {
        int LA = Integer.MAX_VALUE;
        int MI = 0;
        int[] PS = new int[A.size()];
        PS[0] = A.get(0);
        for(int i=1;i<PS.length;i++){
            PS[i] = PS[i-1] + A.get(i);
        }
        for(int i=0;i<=A.size()-B;i++){
            //Only finding the prefix sum would suffice as the B is constant here so no need tdivide it again.
            int average = 0;
            if (i == 0) {
                average = PS[i+B-1];
            }else {
                average = (PS[i+B-1] - PS[i-1]);
            }

            if(LA>average){
                LA = average;
                MI = i;
            }
        }
        return MI;
    }
}
