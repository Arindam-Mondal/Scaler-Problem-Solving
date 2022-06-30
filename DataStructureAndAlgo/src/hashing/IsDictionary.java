package hashing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Problem Description
 * Surprisingly, in an alien language, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26, return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, length of each word <= 105
 *
 * Sum of the length of all words <= 2 * 106
 *
 *
 *
 * Input Format
 * The first argument is a string array A of size N.
 *
 * The second argument is a string B of size 26, denoting the order.
 *
 *
 *
 * Output Format
 * Return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = ["hello", "scaler", "interviewbit"]
 *  B = "adhbcfegskjlponmirqtxwuvzy"
 * Input 2:
 *
 *  A = ["fine", "none", "no"]
 *  B = "qwertyuiopasdfghjklzxcvbnm"
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The order shown in string B is: h < s < i for the given words. So return 1.
 * Explanation 2:
 *
 *  "none" should be present after "no". Return 0.
 */
public class IsDictionary {
    public int solve(ArrayList<String> A, String B) {
            HashMap<Character,Integer> OM = new HashMap<>();
        for(int i=0;i<B.length();i++){
            OM.put(B.charAt(i),i);
        }
        int order = 0;
        for(int i=0;i<A.size()-1;i++){
            int compare = compareString(A.get(i),A.get(i+1),OM);
            if(compare > 0){
                return 0;
            }
        }
        return 1;
    }

    public int compareString(String a, String b, HashMap<Character, Integer> order){
        //both equal return 0
        //a>b return 1
        //a<b return -1
        int i=0;
        int j=0;
        while(i<a.length() && j<b.length()){
            int fa = order.get(a.charAt(i));
            int fb = order.get(b.charAt(i));
            if(fa>fb){
                return 1;
            }else if(fa<fb){
                return -1;
            }
            i++;
            j++;
        }

        if(a.length()>b.length()){
            return 1;
        }else if (b.length()>a.length()){
            return -1;
        }else{
            return 0;
        }
    }
}
