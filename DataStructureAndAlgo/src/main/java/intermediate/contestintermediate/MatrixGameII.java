package intermediate.contestintermediate;

import java.util.Scanner;

/**
 * Question wa part of Scaler contest
 *
 * <div ng-bind-html="trustedHtml" class="ng-binding"><p><strong>Problem Description</strong><br> </p>
 *  <div id="problem_description_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p></p>
 * <p>Write a program to input two integers <strong>N and M.</strong> Now you have a 2-D array A of size N * M. It has all the integers from 1 to N * M exactly once and they are inserted in this 2-D array sequentially in a row major order. </p>
 * <p><strong>E.g.</strong>Suppose N = 2 and M = 3, then 2-D array is {{1,2,3},{4,5,6}}</p>
 * <p>Now you have Q queries of following four types: </p><ul>
 * <li>1 C1 C2: Swap elements of Column C1 with Column C2. </li>
 * <li>2 R1 R2: Swap elements of Row R1 with Row R2. </li>
 * <li>3 X1 Y1 X2 Y2: Print the Bitwise OR of element A[X1][Y1] with A[X2][Y2] in updated 2-D array.</li>
 * <li>4 X1 Y1 X2 Y2: Print the Bitwise AND of element A[X1][Y1] with A[X2][Y2] in updated 2-D array.</li></ul><p></p>
 * <p></p></div>
 * <p><br><br><strong>Problem Constraints</strong><br> </p>
 *  <div id="problem_constraints_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p></p>
 * <p>1 &lt;= N, M, Q &lt;= 100000</p>
 * <p>1 &lt;= R1, R2, X1, X2 &lt;= N</p>
 * <p></p><p>1 &lt;= C1, C2, Y1, Y2 &lt;= M</p></div>
 * <p><br><br><strong>Input Format</strong><br> </p>
 *  <div id="input_format_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p></p>
 * <p>First line has three space separated integers <strong>N, M and Q</strong>.</p>
 * <p>Next <strong>Q</strong> lines contain 3 or 5 space seprated integers as per the queries mentioned in the question. (First integer will always be either 1 or 2 or 3 or 4).</p>
 * <p></p></div>
 * <p><br><br><strong>Output Format</strong><br> </p>
 *  <div id="output_format_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p></p>
 * <p>For each query of type 3 or 4 print a single integer representing answer for that query in one line.</p>
 * <p></p></div>
 * <p><br><br><strong>Example Input</strong><br> </p>
 *  <div id="example_input_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p></p>
 * <p>Input 1:</p>
 * <p></p>
 * <pre>2 3 4
 * 1 2 3
 * 3 1 2 2 2
 * 2 1 2
 * 4 1 2 2 3</pre>
 * <p></p></div>
 * <p><br><br><strong>Example Output</strong><br> </p>
 *  <div id="example_output_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p></p>
 * <p>Output 1:</p>
 * <p></p>
 * <pre>7
 * 2</pre>
 * <p></p></div>
 * <p><br><br></p></div>
 */
public class MatrixGameII {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[] ri = new int[n];
        int[] ci = new int[m];
        for(int i=0;i<n;i++){
            ri[i] = i;
        }
        for(int j=0;j<m;j++){
            ci[j] = j;
        }
        for(int p=0;p<q;p++){

            int ops1 = sc.nextInt();
            if(ops1 == 1){
                //swap cols C1 with C2
                int c1 = sc.nextInt()-1;
                int c2 = sc.nextInt()-1;
                int temp = ci[c1];
                ci[c1] = ci[c2];
                ci[c2] = temp;

            }
            if(ops1 == 2){

                int r1 = sc.nextInt()-1;
                int r2 = sc.nextInt()-1;
                int temp = ri[r1];
                ri[r1] = ri[r2];
                ri[r2] = temp;

            }
            if(ops1 == 3 || ops1 == 4){
                int x1 = sc.nextInt()-1;
                int y1 = sc.nextInt()-1;
                int x2 = sc.nextInt()-1;
                int y2 = sc.nextInt()-1;
                int r1 = ri[x1];
                int r2 = ri[x2];
                int c1 = ci[y1];
                int c2 = ci[y2];
                //This line is very important as we can directly find the element without even storing the element in any array.
                int r1c1 = r1 * m + c1 + 1;
                int r2c2 = r2 * m + c2 + 1;
                if(ops1 == 3)
                    System.out.println(r1c1 | r2c2);
                else
                    System.out.println(r1c1 & r2c2);
            }

        }

    }
}
