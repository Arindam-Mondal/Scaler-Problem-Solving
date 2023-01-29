package advance.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Generate Parentheses
 * Medium
 * 16.7K
 * 660
 * Companies
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 *
 */

public class GnerateParanthesis {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        char[] paranthesis = new char[n*2];

        generateParanthesisHelper(n,paranthesis,res,0);
        return res;

    }

    public void generateParanthesisHelper(int n, char[] paranthesis, ArrayList<String> res,int pos){
        if((n*2)==pos){
            if(isvalidParenthesis(paranthesis)){
                StringBuilder s = new StringBuilder();
                for(char c:paranthesis){
                    s.append(c);
                }
                res.add(s.toString());
            }
            return;
        }

        //either add '('
        //or
        //add ')'
        paranthesis[pos] = '(';
        generateParanthesisHelper(n,paranthesis,res,pos+1);
        paranthesis[pos] = ')';
        generateParanthesisHelper(n,paranthesis,res,pos+1);
    }

    public boolean isvalidParenthesis(char[] paranthesis){
        int open = 0;
        int close = 0;
        for(char c : paranthesis){
            if(c == '('){
                open++;
            }else{
                close++;
            }
            if(close>open){
                return false;
            }
        }
        return open == close;
    }
}
