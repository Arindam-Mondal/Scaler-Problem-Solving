package advance.recursion;

import java.util.Scanner;

/**
 * Problem Description
 * Write a recursive function that, given a string S, prints the characters of S in reverse order.
 *
 *
 *
 * Problem Constraints
 * 1 <= |s| <= 1000
 *
 *
 *
 * Input Format
 * First line of input contains a string S.
 *
 *
 *
 * Output Format
 * Print the character of the string S in reverse order.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  scaleracademy
 * Input 2:
 *
 *  cool
 *
 *
 * Example Output
 * Output 1:
 *
 *  ymedacarelacs
 * Output 2:
 *
 *  looc
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Print the reverse of the string in a single line.
 */
public class ReverseString {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String reverseString = reverseString(line,line.length()-1);
        System.out.println(reverseString);

    }

    public static String reverseString(String S, int pos){
        if(pos<0){
            return "";
        }
        return S.charAt(pos) + reverseString(S,pos-1);
    }
}
