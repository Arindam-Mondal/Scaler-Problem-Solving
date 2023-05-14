package advance.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a string s, partition s such that every
 * substring
 *  of the partition is a
 * palindrome
 * . Return all possible palindrome partitioning of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
public class PalindromeSubstring {
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partitionString(s,0,res,path);
        return res;
    }

    public void partitionString(String s,int idx,List<List<String>> res,List<String> path){
        //can be partioned at position k = 0 to n-1
        if(idx == s.length()){
            res.add(new ArrayList(path));
        }
        for(int k=idx;k<s.length();k++){
            if(isValidPalindrome(s,idx,k)){
                //add to the path
                path.add(s.substring(idx,k+1));
                partitionString(s,k+1,res,path);
                path.remove(path.size()-1);
            }
        }


    }

    public boolean isValidPalindrome(String s,int start, int end){
        int i=start;
        int j=end;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
