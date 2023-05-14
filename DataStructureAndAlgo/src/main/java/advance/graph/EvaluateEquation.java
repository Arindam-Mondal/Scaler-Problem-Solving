package advance.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * Constraints:
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
public class EvaluateEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //Solution using dfs
        //create a Map of map of string to store the dividend and divisor
        Map<String, Map<String,Double>> map = new HashMap<>();

        for(int i=0;i<equations.size();i++){
            List<String> equation = equations.get(i);

            String dividend = equation.get(0);
            String divisor = equation.get(1);

            double value = values[i];

            Map<String,Double> dividendMap = map.getOrDefault(dividend,new HashMap<>());
            Map<String,Double> divisorMap = map.getOrDefault(divisor,new HashMap<>());

            dividendMap.put(divisor,value);
            divisorMap.put(dividend,1/value);

            map.put(dividend,dividendMap);
            map.put(divisor,divisorMap);
        }

        double[] res = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            List<String> query = queries.get(i);
            String dividentQ = query.get(0);
            String divisorQ = query.get(1);

            if(!map.containsKey(dividentQ) || !map.containsKey(dividentQ)){
                res[i] = -1;
            } else{
                res[i] = dfs(map,dividentQ,divisorQ,1.0,new HashSet<>());
            }

        }

        return res;
    }

    public double dfs(Map<String,Map<String,Double>> map, String start, String end, double r, HashSet<String> seen){
        if(start.equals(end)){
            return r;
        }
        //get the neighbours
        Map<String,Double> neighbour = map.get(start);
        for(String next : neighbour.keySet()){
            if(seen.contains(next)){
                continue;
            }
            seen.add(next);
            double res = dfs(map,next,end,r*neighbour.get(next),seen);
            if(res != -1){
                return res;
            }
            seen.remove(next);
        }
        return -1;
    }
}
