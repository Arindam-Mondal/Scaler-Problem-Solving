package advance.binarysearch;

/**
 * Ath Magical Number
 *
 * Problem Description
 * You are given three positive integers, A, B, and C.
 *
 * Any positive integer is magical if divisible by either B or C.
 *
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 *
 * 2 <= B, C <= 40000
 *
 *
 *
 * Input Format
 * The first argument given is an integer A.
 *
 * The second argument given is an integer B.
 *
 * The third argument given is an integer C.
 *
 *
 *
 * Output Format
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 1
 *  B = 2
 *  C = 3
 * Input 2:
 *
 *  A = 4
 *  B = 2
 *  C = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  1st magical number is 2.
 * Explanation 2:
 *
 *  First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 */
public class AthMagicalNumber {
    public int solve(int A, int B, int C) {

        if(B>C){
            return solve(A,C,B);
        }

        //Find the range
        int mod = 1000000007;
        long low = B;
        long high = (long)A * B;
        long ans = 0;

        while(low<=high){
            long mid = low + (high-low)/2;
            //no of factors of A in the range till mid
            //to do that we would be using the below formula
            long count = mid/B + mid/C - mid/LCM(B,C);

            if(count>=A){
                high = mid-1;
                ans = mid;
            }else{
                low =mid+1;
            }
        }
        return (int)(ans % 1000000007);

    }

    public long LCM(int A, int B){
        //we know A * B = LCM(A,B) * GCD(A,B);
        //LCM(A,B) = (A * B)/GCD(A,B);
        int mod = 1000000007;
        return A/GCD(A,B) * (long)B;
    }

    public int GCD(int a, int b){
        if (a == 0){
            return b;
        }
        return GCD(b%a,a);
    }
}
