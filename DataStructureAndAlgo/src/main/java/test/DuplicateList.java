package test;

import java.util.ArrayList;

public class DuplicateList {

    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> intList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        intList.add(list1);

        boolean isPresent = intList.contains(list2);

        System.out.print(isPresent);

        list2.add(1);
        list2.add(2);

        isPresent = intList.contains(list2);

        System.out.print(isPresent);
    }
}
