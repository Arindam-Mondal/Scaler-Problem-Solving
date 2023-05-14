package advance.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Problem Description
 * Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
 *
 * String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
 *
 * Find and return the postfix expression of A.
 *
 * NOTE:
 *
 * ^ has the highest precedence.
 * / and * have equal precedence but greater than + and -.
 * + and - have equal precedence and lowest precedence among given operators.
 *
 *
 * Problem Constraints
 * 1 <= length of the string <= 500000
 *
 *
 *
 * Input Format
 * The only argument given is string A.
 *
 *
 *
 * Output Format
 * Return a string denoting the postfix conversion of A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "x^y/(a*z)+b"
 * Input 2:
 *
 *  A = "a+b*(c^d-e)^(f+g*h)-i"
 *
 *
 * Example Output
 * Output 1:
 *
 * "xy^az*\/b+"
 *
 * Output 2:
 *
 *  "abcd^e-fgh*+^*+i-"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Ouput dentotes the postfix expression of the given input.
 */

/**
 * Steps followed
 *
 * Begin
 *    initially push some special character say # into the stack
 *    for each character ch from infix expression, do
 *       if ch is alphanumeric character, then
 *          add ch to postfix expression
 *       else if ch = opening parenthesis (, then
 *          push ( into stack
 *       else if ch = ^, then            //exponential operator of higher precedence
 *          push ^ into the stack
 *       else if ch = closing parenthesis ), then
 *          while stack is not empty and stack top ≠ (,
 *             do pop and add item from stack to postfix expression
 *          done
 *
 *          pop ( also from the stack
 *       else
 *          while stack is not empty AND precedence of ch <= precedence of stack top element, do
 *             pop and add into postfix expression
 *          done
 *
 *          push the newly coming character.
 *    done
 *
 *    while the stack contains some remaining characters, do
 *       pop and add to the postfix expression
 *    done
 *    return postfix
 * End
 */
public class InfixToPostfix {
    public String solve(String A) {
        Map<Character,Integer> precedenceMap = new HashMap<>();

        precedenceMap.put('^',3);
        precedenceMap.put('*',2);
        precedenceMap.put('/',2);
        precedenceMap.put('+',1);
        precedenceMap.put('-',1);
        precedenceMap.put('(',0);
        precedenceMap.put(')',0);

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = A.length();
        for(int i=0;i<n;i++){
            char c = A.charAt(i);
            if(c>='a' && c<='z'){
                sb.append(c);
            }else if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                while(!stack.empty() && stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }else{
                if(!stack.empty() && precedenceMap.get(c)>precedenceMap.get(stack.peek())){
                    stack.push(c);
                }else{
                    while(!stack.empty() && precedenceMap.get(c)<=precedenceMap.get(stack.peek())){
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
