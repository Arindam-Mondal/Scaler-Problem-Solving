package intermediate.modular;

/**
 * Problem Description
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the column title <= 5
 *
 *
 *
 * Input Format
 * The only argument is a string that represents the column title in the excel sheet.
 *
 *
 *
 * Output Format
 * Return a single integer that represents the corresponding column number.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  AB
 * Input 2:
 *
 *  ABCD
 *
 *
 * Example Output
 * Output 1:
 *
 *  28
 * Output 2:
 *
 *  19010
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28
 */
public class ExcelColumnNumber {
    public int titleToNumber(String A) {
        int result = 0;
        for(int i=A.length()-1;i>=0;i--){
            result = result + ((A.charAt(i) % 64) * (int)Math.pow(26,A.length()-i-1));
        }
        return result;

    }
}
