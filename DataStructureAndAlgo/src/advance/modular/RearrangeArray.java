package advance.modular;

import java.util.ArrayList;

/**
 * Rearrange Array
 *
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
 *
 * Example:
 *
 * Input : [1, 0]
 * Return : [0, 1]
 * Lets say N = size of the array. Then, following holds true :
 *
 * All elements in the array are in the range [0, N-1]
 * N * N does not overflow for a signed integer
 */
public class RearrangeArray {
    public void arrange(ArrayList<Integer> a) {
        int n = a.size();

        for(int i=0;i<n;i++){
            a.set(i,a.get(i) * n);
        }

        for(int i=0;i<n;i++){
            int index = a.get(i)/n;
            int val = a.get(index)/n;
            a.set(i,a.get(i) + val);
        }

        for(int i=0;i<n;i++){
            a.set(i,a.get(i) % n);
        }
    }
}
