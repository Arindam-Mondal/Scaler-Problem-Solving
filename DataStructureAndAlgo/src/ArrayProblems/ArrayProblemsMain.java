package ArrayProblems;

import java.util.ArrayList;

public class ArrayProblemsMain {
    public static void main(String[] args) {
        AntiDiagonals ad = new AntiDiagonals();
        ArrayList<ArrayList<Integer>> TDA = new ArrayList<>();
        ArrayList<Integer> S = new ArrayList<>();
        for(int i=1;i<=3;i++){
            S.add(i);
        }
        TDA.add(S);
        S = new ArrayList<>();
        for(int i=4;i<=6;i++){
            S.add(i);
        }
        TDA.add(S);
        S = new ArrayList<>();
        for(int i=7;i<=9;i++){
            S.add(i);
        }
        TDA.add(S);

        System.out.println(ad.diagonal(TDA));
    }
}
