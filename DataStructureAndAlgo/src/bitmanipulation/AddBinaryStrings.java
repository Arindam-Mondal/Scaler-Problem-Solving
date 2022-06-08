package bitmanipulation;

/**
 * Problem Description
 * Given two binary strings, return their sum (also a binary string).
 * Example:
 *
 * a = "100"
 *
 * b = "11"
 * Return a + b = "111".
 */
public class AddBinaryStrings {
    public String addBinary(String A, String B) {
        int n1 = A.length()-1;
        int n2 = B.length()-1;
        String result = "";
        int c = 0;
        while(n1>=0 || n2>=0) {
            int v1 = 0;
            int v2 = 0;
            if(n1>=0){
                v1 = Character.getNumericValue(A.charAt(n1));
                n1--;
            }
            if(n2>=0){
                v2 = Character.getNumericValue(B.charAt(n2));
                n2--;
            }
            int s = v1+v2+c;
            int value = s % 2;
            c=s/2;
            result = value + result;
        }
        if(c>=1) result = c + result;
        return result;
    }
}
