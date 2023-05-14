package advance.modular;

/**
 * Problem Description
 * Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
 *
 * "^" means power,
 *
 * "%" means "mod", and
 *
 * "!" means factorial.
 *
 *
 *
 * Problem Constraints
 * 1 <= A, B <= 5e5
 *
 *
 *
 * Input Format
 * First argument is the integer A
 *
 * Second argument is the integer B
 *
 *
 *
 * Output Format
 * Return one integer, the answer to the problem
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 1
 * B = 1
 * Input 2:
 *
 * A = 2
 * B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 4
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  1! = 1. Hence 1^1 = 1.
 * Explanation 2:
 *
 *  2! = 2. Hence 2^2 = 4.
 */
public class VeryLargePower {
    public int solve(int A, int B) {
        //Based on Little fermat's theorem - we need to solve this problem
        int mod = 1000000007;
        int power = findPower(B,mod);
        return power(A,power,mod);

    }

    public int power(int A, int B,int mod){
        if(B<=0){
            return 1;
        }
        if(B == 1){
            return A;
        }
        int halfPower = power(A,B/2,mod);
        if(B%2==0){
            return (int)((long)halfPower%mod * (long)halfPower%mod)%mod;
        }else{
            return (int)((long)halfPower%mod * (long)halfPower%mod * (long)A%mod)%mod;
        }
    }
    public int findPower(int B, int p){
        //first find the B factorial
        long fact = 1;
        for(int i=2;i<=B;i++){
            fact = (fact * i)%(p-1);
        }
        return (int)(fact % (p-1));
    }
}
