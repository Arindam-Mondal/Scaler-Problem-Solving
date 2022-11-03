package advance.trie;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * Given a list of N words, find the shortest unique prefix to represent each word in the list.
 *
 * NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible
 *
 *
 *
 * Problem Constraints
 * 1 <= Sum of length of all words <= 106
 *
 *
 *
 * Input Format
 * First and only argument is a string array of size N.
 *
 *
 *
 * Output Format
 * Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = ["zebra", "dog", "duck", "dove"]
 * Input 2:
 *
 * A = ["apple", "ball", "cat"]
 *
 *
 * Example Output
 * Output 1:
 *
 *  ["z", "dog", "du", "dov"]
 * Output 2:
 *
 *  ["a", "b", "c"]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Shortest unique prefix of each word is:
 *  For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 *  For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 *  For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 *  For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".
 *
 * Explanation 2:
 *
 *  "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.
 *
 */
class Node {
    int ps;
    HashMap<Character,Node> path;
    Node(int ps){
        this.path = new HashMap<>();
        this.ps = ps;
    }
}

public class ShortestUniquePrefix {
    public ArrayList<String> prefix(ArrayList<String> A) {
        Node root = new Node(0);
        int n = A.size();
        for(int i=0;i<n;i++){
            String s = A.get(i);
            Node temp = root;
            for(int j=0;j<s.length();j++){
                char c = s.charAt(j);
                if(temp.path.get(c) == null){
                    //insert a node;
                    Node newNode = new Node(1);
                    temp.path.put(c,newNode);
                    temp = temp.path.get(c);
                }else{
                    //keep traversing amd increment the ps;
                    Node existingNode = temp.path.get(c);
                    existingNode.ps = existingNode.ps + 1;
                    temp = temp.path.get(c);
                }
            }
        }
        ArrayList<String> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            String s = A.get(i);
            Node temp = root;
            StringBuilder sb = new StringBuilder("");
            for(int j=0;j<s.length();j++){
                char c = s.charAt(j);
                if(temp.path.get(c).ps == 1){
                    sb.append(c);
                    break;
                }else{
                    sb.append(c);
                }
                temp = temp.path.get(c);
            }
            result.add(sb.toString());
        }
        return result;
    }
}
