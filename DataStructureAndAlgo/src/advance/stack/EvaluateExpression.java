package advance.stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Evaluate Expression
 *
 * Problem Description
 * An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each string may be an integer or an operator.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 *
 *
 * Input Format
 * The only argument given is string array A.
 *
 *
 *
 * Output Format
 * Return the value of arithmetic expression formed using reverse Polish Notation.
 *
 *
 *
 * Example Input
 * Input 1:
 *     A =   ["2", "1", "+", "3", "*"]
 * Input 2:
 *     A = ["4", "13", "5", "/", "+"]
 *
 *
 * Example Output
 * Output 1:
 *     9
 * Output 2:
 *     6
 *
 *
 * Example Explanation
 * Explaination 1:
 *     starting from backside:
 *     * : () * ()
 *     3 : () * (3)
 *     + : (() + ()) * (3)
 *     1 : (() + (1)) * (3)
 *     2 : ((2) + (1)) * (3)
 *     ((2) + (1)) * (3) = 9
 * Explaination 2:
 *     + : () + ()
 *     / : () + (() / ())
 *     5 : () + (() / (5))
 *     13 : () + ((13) / (5))
 *     4 : (4) + ((13) / (5))
 *     (4) + ((13) / (5)) = 6
 */
public class EvaluateExpression {
    public int evalRPN(ArrayList<String> A) {
        Set<String> operandSet = new HashSet<>();
        operandSet.add("+");
        operandSet.add("-");
        operandSet.add("*");
        operandSet.add("/");

        Stack<String> expression = new Stack();
        for(int i=0;i<A.size();i++){
            String exp = A.get(i);
            if(!expression.empty() && operandSet.contains(exp)){
                int exp1 = Integer.parseInt(expression.pop());
                int exp2 = Integer.parseInt(expression.pop());
                int result = calculate(exp1,exp2,exp);
                // System.out.println(exp1 + " " + exp2 + " "+ exp + " " + result);
                expression.push(String.valueOf(result));
            }else{
                expression.push(exp);
            }
            // System.out.println(expression);
        }
        return Integer.parseInt(expression.peek());
    }

    public int calculate(int a, int b, String operand){
        // System.out.println(a + " " + b + " "+ operand);
        if( ("+").equals(operand)){
            return b+a;
        }else if("-".equals(operand)){
            return b-a;
        }else if("*".equals(operand)){
            return b*a;
        }else{
            return b/a;
        }
    }
}
