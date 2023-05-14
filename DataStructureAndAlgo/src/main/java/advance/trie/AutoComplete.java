package advance.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * Problem Description
 * There is a dictionary A of N words, and ith word has a unique weight Wi.
 *
 * Another string array B of size M contains the prefixes. For every prefix B[i], output atmost 5 words from the dictionary A that start with the same prefix.
 *
 * Output the words in decreasing order of their weight.
 *
 * NOTE: If there is no word that starts with the given prefix output -1.
 *
 *
 *
 * Problem Constraints
 * 1 <= T <= 5
 *
 * 1 <= N <= 20000
 * 1 <= M <= 10000
 *
 * 1 <= Wi <= 106
 *
 * 1 <= length of any string either in A or B <= 30
 *
 *
 *
 * Input Format
 * First line is an integer T denoting the number of test cases.
 * For each test case,
 *
 * First line denotes two space seperated integer N and M.
 * Second line denotes N space seperated strings denoting the words in dictionary.
 * Third line denotes N space seperated integers denoting the weight of each word in the dictionary.
 * Fourth line denotes M space seperated integers denoting the prefixes.
 *
 *
 * Output Format
 * For every prefix B[i], print the space seperated output on a new line.
 *
 * NOTE: After every output there should be a space.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  1
 *  6 3
 *  abcd aecd abaa abef acdcc acbcc
 *  2 1 3 4 6 5
 *  ab abc a
 * Input 2:
 *
 *  1
 *  5 3
 *  aaaa aacd abaa abaa aadcc
 *  3 4 1 2 6
 *  aa aba abc
 *
 *
 * Example Output
 * Output 1:
 *
 *  abef abaa abcd
 *  abcd
 *  acdcc acbcc abef abaa abcd
 * Output 2:
 *
 *  aadcc aacd aaaa
 *  abaa abaa
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  For the prefix "ab" 3 words in the dictionary have same prefix: ("abcd" : 2, "abaa" : 3, "abef" : 4). Ouput them in decreasing order of weight.
 *  For the prefix "abc" only 1 word in the dictionary have same prefix: ("abcd" : 2).
 *  For the prefix "a" all 6 words in the dictionary have same prefix: ("abcd" : 2, "aecd" : 1, "abaa" : 3, "abef" : 4, "acdcc" : 6, "acbcc" : 5).
 *  Since we can output atmost 5 words. Output top 5 weighted words in decreasing order of weight.
 * Explanation 2:
 *
 *  For the prefix "aa" 3 words in the dictionary have same prefix: ("aaaa" : 3, "aacd" : 4, "aadcc" : 6). Ouput them in decreasing order of weight.
 *  For the prefix "aba" 2 words in the dictionary have same prefix: ("abaa" : 1, "abaa" : 2).
 *  For the prefix "abc" there is no word in the dictionary which have same prefix. So print -1.
 *
 */
class Word{
    boolean isComplete;
    ArrayList<Integer> indices;
    HashMap<Character,Word> charMap;
    Word(){
        this.charMap = new HashMap<>();
        this.isComplete = false;
        this.indices = new ArrayList<>();

    }

}

class InputWord {
    String str;
    Integer weight;
    InputWord(String str,Integer weight){
        this.str = str;
        this.weight = weight;
    }
}

public class AutoComplete {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i=0;i<tc;i++){
            int inputSize = sc.nextInt();
            int prefixSize = sc.nextInt();
            ArrayList<String> inputList = new ArrayList<>();
            ArrayList<Integer> weightList = new ArrayList<>();

            for(int j=0;j<inputSize;j++){
                inputList.add(sc.next());
            }


            for(int j=0;j<inputSize;j++){
                weightList.add(sc.nextInt());
            }

            ArrayList<InputWord> inputWord = new ArrayList<>();

            for(int j=0;j<inputSize;j++){
                inputWord.add(new InputWord(inputList.get(j),weightList.get(j)));
            }

            inputWord.sort((a,b)->b.weight.compareTo(a.weight));

            Word root = new Word();

            for(int j=0;j<inputSize;j++){
                createWordStructure(root,inputWord.get(j).str,j);
            }

            ArrayList<String> prefix = new ArrayList<>();

            for(int j=0;j<prefixSize;j++){
                String s = sc.next();
                ArrayList<String> result = prefixSearch(s,root,inputWord);
                for(int k=0;k<result.size();k++){
                    System.out.print(result.get(k) + " ");
                }
                System.out.println();
            }
        }

    }
    public static void createWordStructure(Word root,String str, int index){

        Word temp = root;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(temp.charMap.get(c) == null){
                Word newWord = new Word();
                temp.charMap.put(c,newWord);
            }
            temp = temp.charMap.get(c);
            temp.indices.add(index);
        }
        temp.isComplete = true;
    }

    public static ArrayList<String> prefixSearch(String prefix,Word root,ArrayList<InputWord> inputWord){
        //Search for all the prefix here

        Word temp = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(temp.charMap.get(c) == null){
                //No such word exist with the prefix;
                ArrayList<String> notFound = new ArrayList<String>();
                notFound.add("-1");
                return notFound;
            }
            temp = temp.charMap.get(c);
        }

        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<temp.indices.size() & i<5;i++){
            result.add(inputWord.get(temp.indices.get(i)).str);
        }

        return result;

    }
}
