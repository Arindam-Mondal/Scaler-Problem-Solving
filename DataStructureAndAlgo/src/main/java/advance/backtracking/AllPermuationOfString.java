package advance.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPermuationOfString {

    public List<String> findPermutations(String str){
        List<String> resultList = new ArrayList<>();
        permute(str,0,str.length()-1,resultList);
        return resultList;
    }

    public void permute(String str,int l, int r,List<String> result){
        if(l==r){
//            System.out.println(str);
            result.add(str);
        }
        for(int i=l;i<=r;i++){
            str = swap(str,l,i);
            permute(str,l+1,r,result);
            str = swap(str,l,i);
        }
    }

    private String swap(String str, int l, int i) {
        char[] charArray = str.toCharArray();
        char temp = charArray[l];
        charArray[l] = charArray[i];
        charArray[i] = temp;
        return String.valueOf(charArray);
    }


    public static void main(String[] args) {
        AllPermuationOfString alps = new AllPermuationOfString();
        List<String> result = alps.findPermutations("ABC");
//        result.forEach(System.out::println);
        for(String s : result){
            System.out.println(s);
        }
    }

}
