package advance.trie;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Problem Description
 *
 * Given a phone directory in the form of string array A containing N numeric strings.
 *
 * If any phone number is prefix of another phone number then phone directory is invalid else it is valid.
 *
 * You need to check whether the given phone directory is valid or not if it is valid then return 1 else return 0.
 *
 *
 *
 * Problem Constraints
 *
 * 2 <= N <= 105
 *
 * 1 <= |A[i]| <= 50
 *
 * A[i] consists only of numeric digits.
 *
 *
 *
 * Input Format
 *
 * First and only argument is an string array A.
 *
 *
 *
 * Output Format
 *
 * Return 1 if the given phone directory is valid else return 0.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = ["1234", "2342", "567"]
 * Input 2:
 *
 *  A = ["00121", "001"]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  No number is prefix of any other number so phone directory is valid so we will return 1.
 * Explanation 2:
 *
 *  "001" is prefix of "00121" so phone directory is invalid so we will return 0.
 */
class Directory{
    HashMap<Character,Directory> child;
    int ps;
    Directory(){
        this.child = new HashMap<Character,Directory>();
        ps = 0;
    }
}
public class ValidPhoneDirectory {
    public int solve(ArrayList<String> A) {
        Directory root = new Directory();
        for(int i=0;i<A.size();i++){
            if(!insertAndValidateDirectory(root,A.get(i))){
                return 0;
            }
        }
        return 1;

    }
    public boolean insertAndValidateDirectory(Directory root,String s){
        Directory temp = root;
        char c = s.charAt(0);
        if(temp.child.get(c)!=null){
            return false;
        }
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            Directory directory = new Directory();
            temp.child.put(c,directory);
            temp = temp.child.get(c);
        }
        return true;
    }
}
