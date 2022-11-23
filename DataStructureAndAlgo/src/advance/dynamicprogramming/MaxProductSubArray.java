package advance.dynamicprogramming;

import java.util.List;

public class MaxProductSubArray {
    public int maxProduct(final List<Integer> A) {

        //create a prefix product array and keep storing the max
        int result = Integer.MIN_VALUE;
        int prod1 = A.get(0);
        int prod2 = A.get(0);
        result = Math.max(result,Math.max(prod2,prod1));
        for(int i=1;i<A.size();i++){
            int temp = Math.max(A.get(i),Math.max(prod1*A.get(i),prod2*A.get(i)));
            prod2 = Math.min(A.get(i),Math.min(prod1*A.get(i),prod2*A.get(i)));
            prod1 = temp;

            result = Math.max(result,Math.max(prod2,prod1));
        }

        return result;
    }
}
