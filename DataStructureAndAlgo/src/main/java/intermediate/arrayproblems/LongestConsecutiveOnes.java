package intermediate.arrayproblems;

/**
 * Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.
 *
 *
 * Input Format
 *
 * The only argument given is string A.
 * Output Format
 *
 * Return the length of the longest consecutive 1’s that can be achieved.
 * Constraints
 *
 * 1 <= length of string <= 1000000
 * A contains only characters 0 and 1.
 * For Example
 *
 * Input 1:
 *     A = "111000"
 * Output 1:
 *     3
 *
 * Input 2:
 *     A = "111011101"
 * Output 2:
 *     7
 *
 *  Reference ataken from GeeksforGeek - https://www.geeksforgeeks.org/length-of-longest-consecutive-ones-by-at-most-one-swap-in-a-binary-string/
 *
 *  [TODO] Need to Revisit again - bit complex
 */
public class LongestConsecutiveOnes {
    public int solve(String A) {
        int max_cnt = 0;
        int cnt_one = 0;
        int temp = 0;
        int n = A.length();
        //First Counting all the one's in a string.
        for(int i=0;i<n;i++){
            if(A.charAt(i)=='1'){
                cnt_one++;
                temp++;
            }else {
                max_cnt = Math.max(max_cnt,temp);
                temp=0;
            }
        }
        max_cnt = Math.max(max_cnt,temp);
        int[] left = new int[n];
        int[] right = new int[n];

        if(A.charAt(0)=='1'){
            left[0] = 1;
        }else {
            left[0] = 0;
        }

        if(A.charAt(n-1) == '1'){
            right[n-1] = 1;
        }else{
            right[n-1] = 0;
        }

        for(int i=1;i<n;i++){
            if(A.charAt(i)=='1'){
                left[i] = left[i-1] + 1;
            }else {
                left[i] = 0;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(A.charAt(i)=='1'){
                right[i] = right[i+1] + 1;
            }else {
                right[i] = 0;
            }
        }
        for(int i=1;i<n-1;i++){
            if(A.charAt(i)=='0'){
                int sum = left[i-1] + right[i+1];
                if(sum<cnt_one){
                    max_cnt = Math.max(max_cnt,sum+1);
                }
                else {
                    max_cnt = Math.max(max_cnt,sum);
                }
            }
        }
        return max_cnt;
    }
}
