package arrayproblems;

import java.util.List;

public class MaxSumContiguousSubarray {
    public static void main(String[] args) {
        //call the below method from here.
    }
}

class MaxSumContiguousSubarraySolution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        int maxSum = A.get(0);
        int maxTillNow = A.get(0) < 0 ? 0 : A.get(0);
        for(int i=1;i<A.size();i++){
            maxSum = maxSum < maxTillNow + A.get(i) ? maxTillNow + A.get(i) : maxSum;
            maxTillNow = maxTillNow + A.get(i);
            if(maxTillNow < 0) maxTillNow = 0;
        }
        return maxSum;
    }
}

