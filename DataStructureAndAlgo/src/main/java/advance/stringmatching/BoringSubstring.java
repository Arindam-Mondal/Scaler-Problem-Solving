package advance.stringmatching;

import java.util.ArrayList;
import java.util.List;

public class BoringSubstring {
    public int solve(String A) {
        //divide the string into odd and even paritry
        //sort the string
        //combine first letter of odd and last letter of even and check if they are consecutive - if not return 1
        //else combine last letter of even and first letter of odd and then check if they are consecutive  - if not return 1
        //else return 0
        List<Character> oddParity = new ArrayList<>();
        List<Character> evenParity = new ArrayList<>();

        for(int i=0;i<A.length();i++){
            if(A.charAt(i)%2==0){
                evenParity.add(A.charAt(i));
            }else{
                oddParity.add(A.charAt(i));
            }
        }
        evenParity.sort((a,b)->a.compareTo(b));
        oddParity.sort((a,b)->a.compareTo(b));

        int nEven = evenParity.size();
        int nOdd = oddParity.size();

        if(Math.abs(evenParity.get(0)-oddParity.get(nOdd-1)) != 1){
            return 1;
        }
        if(Math.abs(oddParity.get(0)-evenParity.get(nEven-1)) != 1){
            return 1;
        }
        return 0;
    }
}
