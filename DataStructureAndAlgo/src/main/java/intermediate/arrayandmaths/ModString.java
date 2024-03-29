package intermediate.arrayandmaths;

/**
 * Problem Description
 * You are given a large number in the form of a string A where each character denotes a digit of the number.
 * You are also given a number B. You have to find out the value of A % B and return it.
 *
 *
 *
 * Problem Constraints
 * 1 <= A.length() <= 105
 * 0 <= Ai <= 9
 * 1 <= B <= 109
 *
 *
 * Input Format
 * The first argument is a string A.
 * The second argument is an integer B.
 *
 *
 * Output Format
 * Return a single integer denoting the value of A % B.
 *
 *
 * Example Input
 * Input 1:
 * A = "143"
 * B = 2
 * Input 2:
 *
 * A = "43535321"
 * B = 47
 *
 *
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 *
 * 20
 *
 *
 * Example Explanation
 * Explanation 1:
 * 143 is an odd number so 143 % 2 = 1.
 * Explanation 2:
 *
 * 43535321 % 47 = 20
 */
public class ModString {

    public int findMod(String A, int B) {
        long M = 0;
        int C = 10 % B;
        long V = 1;
        for(int i=A.length()-1;i>=0;i--){
            int num = Character.getNumericValue(A.charAt(i));
            M = (M + (num * V)) % B;
            V = (C * V) % B;
        }
        return (int)M%B;
    }
}
