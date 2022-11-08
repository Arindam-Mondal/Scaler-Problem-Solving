package advance.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 0 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum result of A[i] XOR A[j].
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  7
 * Output 2:
 *
 *  117
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.
 * Explanation 2:
 *
 *  Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.
 *
 */
class Xor{
    Map<Integer,Xor> child;
    int val;
    Xor(){
        this.child = new HashMap<>();
        this.val = val;
    }
}

public class MaximumXor {
    public int solve(ArrayList<Integer> A) {
        Xor root = new Xor();
        //first insert
        for(int i=0;i<A.size();i++){
            insert(A.get(i),root);
        }
        int maxXor = 0;
        for(int i=0;i<A.size();i++){
            int possibleMaxXor = findXOR(A.get(i),root)^A.get(i);
            maxXor = Math.max(maxXor,possibleMaxXor);
        }

        return maxXor;
    }

    public void insert(int val,Xor root){
        Xor temp = root;
        for(int i=31;i>=0;i--){
            int bit = 0;
            if(checkBit(val,i)){
                bit = 1;
            }
            if(temp.child.get(bit) == null){
                Xor child = new Xor();
                temp.child.put(bit,child);
            }
            temp = temp.child.get(bit);
        }
        temp.val = val;
    }

    public int findXOR(int val,Xor root){
        Xor temp = root;
        for(int i=31;i>=0;i--){
            int setBit = 1;
            int unSetBit = 0;
            if(checkBit(val,i)){
                setBit = 0;
                unSetBit = 1;
            }
            if(temp.child.get(setBit) == null){
                temp = temp.child.get(unSetBit);
            }else{
                temp = temp.child.get(setBit);
            }
        }
        return temp.val;
    }


    public boolean checkBit(int n,int pos){
        if(((n>>pos)&1)>0){
            return true;
        }else{
            return false;
        }
    }
}
