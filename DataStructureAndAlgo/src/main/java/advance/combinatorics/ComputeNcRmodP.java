package advance.combinatorics;

/**
 *
 * Compute nCr % p
 *
 * Problem Description
 * Given three integers A, B, and C, where A represents n, B represents r, and C represents p and p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.
 *
 * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
 *
 * NOTE: For this problem, we are considering 1 as a prime.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 106
 * 1 <= B <= A
 * A <= C <= 109+7
 *
 *
 * Input Format
 * The first argument given is the integer A ( = n).
 * The second argument given is the integer B ( = r).
 * The third argument given is the integer C ( = p).
 *
 *
 *
 * Output Format
 * Return the value of nCr % p.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 5
 *  B = 2
 *  C = 13
 * Input 2:
 *
 *  A = 6
 *  B = 2
 *  C = 13
 *
 *
 * Example Output
 * Output 1:
 *
 *  10
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  nCr( n=5 and r=2) = 10.
 *  p=13. Therefore, nCr%p = 10.
 */
public class ComputeNcRmodP {
    public int solve(int A, int B, int C) {
        long[] fact = new long[1000001];
        fact[0] = 1L;
        for(int i=1;i<=A;i++){
            fact[i] = ((long)i%C * fact[i-1]%C)%C;
        }
        long ans = fact[A];
        ans = (ans * PowMod(fact[A-B],C-2,C))%C;
        ans = (ans * PowMod(fact[B],C-2,C))%C;
        return (int)ans;
    }

    public long PowMod(long x, long n, long m)
    {
        // Code here
        x %= m;
        long res = 1L;
        while(n>0){
            if((n&1L) == 1L){
                res = (res%m * x%m)%m;
            }
            x = (x%m * x%m)%m;
            n >>= 1L;
        }
        return res;
    }
}
