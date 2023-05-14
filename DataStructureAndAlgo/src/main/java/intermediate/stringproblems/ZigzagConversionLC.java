package intermediate.stringproblems;

import java.util.ArrayList;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 *
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * [TODO] Can be improved further
 */
public class ZigzagConversionLC {
    public String convert(String s, int numRows) {
        int l=0;
        int i=0;
        int j=0;
        ArrayList<ArrayList<Character>> cl = new ArrayList<>();
        for(int k=0;k<numRows;k++){
            ArrayList<Character> tl = new ArrayList<>();
            cl.add(tl);
        }
        while(l<s.length()){
            i=0;
            while(i<numRows && l<s.length()){
                cl.get(i).add(s.charAt(l));
                i++;
                l++;
            }
            j=numRows-2;
            while(j>0 && l<s.length()){
                cl.get(j).add(s.charAt(l));
                j--;
                l++;
            }
        }
        // System.out.println(cl);
        StringBuilder sb = new StringBuilder();
        for(int m=0;m<cl.size();m++){
            for(int n=0;n<cl.get(m).size();n++){
                sb.append(cl.get(m).get(n));
            }
        }

        return sb.toString();
    }
}
