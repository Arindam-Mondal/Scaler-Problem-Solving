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

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        char[] parenthesis = new char[n*2];

        generateParenthesisHelper(n,parenthesis,res,0);
        return res;

    }

    public void generateParenthesisHelper(int n, char[] parenthesis, ArrayList<String> res, int pos){
        if((n*2)==pos){
            if(isValidParenthesis(parenthesis)){
                StringBuilder s = new StringBuilder();
                for(char c:parenthesis){
                    s.append(c);
                }
                res.add(s.toString());
            }
            return;
        }

        //either add '('
        //or
        //add ')'
        parenthesis[pos] = '(';
        generateParenthesisHelper(n,parenthesis,res,pos+1);
        parenthesis[pos] = ')';
        generateParenthesisHelper(n,parenthesis,res,pos+1);
    }

    public boolean isValidParenthesis(char[] parenthesis){
        int open = 0;
        int close = 0;
        for(char c : parenthesis){
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
