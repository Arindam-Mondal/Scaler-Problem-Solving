package advance.stringmatching;

import java.util.HashMap;

/**
 *
 */
public class PermutationAInB {
    public int solve(String A, String B) {
        HashMap<Character,Integer> patternMap = new HashMap<>();
        HashMap<Character,Integer> stringMap = new HashMap<>();

        // if(B.length() < A.length()){
        //     return 0;
        // }

        int l=0;
        int r=0;
        int n = A.length();

        for(int i=0;i<A.length();i++){
            int frequency = patternMap.getOrDefault(A.charAt(i),0);
            patternMap.put(A.charAt(i),frequency+1);
            stringMap.put(A.charAt(i),0);
        }

        for(int i=0;i<n;i++){
            if(stringMap.containsKey(B.charAt(i))){
                int frequency = stringMap.get(B.charAt(i));
                stringMap.put(B.charAt(i),frequency+1);
            }
        }

        int count = 0;
        if(checkMap(stringMap,patternMap)){
            count++;
        }

        // System.out.println(stringMap.size());
        // System.out.println(patternMap.size());

        for(int i=0;i<B.length()-n;i++){

            char removeElement = B.charAt(i);
            char addElement = B.charAt(i+n);
            // System.out.println(stringMap);
            // System.out.println(patternMap);
            if(stringMap.containsKey(removeElement)){
                int frequency = stringMap.get(removeElement);
                stringMap.put(removeElement,frequency-1);
            }
            if(stringMap.containsKey(addElement)){
                int frequency = stringMap.get(addElement);
                stringMap.put(addElement,frequency+1);
            }

            if(checkMap(stringMap,patternMap)){
                count++;
            }
        }

        return count;

    }
    public boolean checkMap(HashMap<Character,Integer> A, HashMap<Character,Integer> B){
        for(Character c : A.keySet()){
            int af = A.get(c);
            int bf = B.get(c);
            if(af != bf){
                return false;
            }
        }
        return true;
    }
}
