package advance.binarysearch;

import java.util.List;

/**
 * KthPrice
 *
 * Given the price list at which tickets for a flight were purchased, figure out the kth smallest price for the flight. kth smallest price is the minimum possible n such that there are at least k price elements in the price list with value <= n. In other words, if the price list was sorted, then A[k-1] ( k is 1 based, while the array is 0 based ).
 *
 * NOTE You are not allowed to modify the price list ( The price list is read only ). Try to do it using constant extra space.
 *
 * Example:
 *
 * A : [2 1 4 3 2]
 * k : 3
 *
 * Answer : 2
 * Constraints :
 *
 * 1 <= number of elements in the price list <= 1000000
 * 1 <= k <= number of elements in the price list
 */
public class KthPrice {
    public int solve(final List<Integer> A, int B) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i=0;i<A.size();i++){
            low = Math.min(low,A.get(i));
            high = Math.max(high,A.get(i));
        }

        while(low<=high){
            int mid = low + (high-low)/2;
            int count = count(A,mid);
            if(count<B){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    public int count(List<Integer> A, int N){
        int count = 0;
        for(int i=0;i<A.size();i++){
            if(A.get(i)<=N){
                count++;
            }
        }
        return count;
    }
}
