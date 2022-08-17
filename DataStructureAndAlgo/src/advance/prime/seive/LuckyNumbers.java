package advance.prime.seive;

/**
 *
 * Lucky Numbers
 *
 * Problem Description
 * A lucky number is a number that has exactly 2 distinct prime divisors.
 *
 * You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 50000
 *
 *
 *
 * Input Format
 * The first and only argument is an integer A.
 *
 *
 *
 * Output Format
 * Return an integer i.e the count of lucky numbers between 1 and A, both inclusive.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 8
 * Input 2:
 *
 *  A = 12
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Between [1, 8] there is only 1 lucky number i.e 6.
 *  6 has 2 distinct prime factors i.e 2 and 3.
 * Explanation 2:
 *
 *  Between [1, 12] there are 3 lucky number: 6, 10 and 12.
 */
public class LuckyNumbers {
    public int solve(int A) {
        //Calculate the seive
        int[] seive = new int[A+1];
        for(int i=0;i<=A;i++){
            seive[i] = i;
        }

        for(int i=2;i*i<=A;i++){
            if(seive[i] == i){
                for(int j=i*i;j<=A;j += i){
                    if(seive[j]==j){
                        seive[j] = i;
                    }
                }
            }
        }
        int result = 0;
        for(int i=2;i<=A;i++){
            int count = 1;
            int number = i;
            int pf = seive[number];
            while(number>1){
                if(pf != seive[number]){
                    count++;
                    pf = seive[number];
                }
                number = number/seive[number];
            }
            if(count == 2){
                result++;
            }
        }

        return result;
    }
}
