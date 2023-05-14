package advance.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Misha and Candies
 *
 * Problem Description
 * Misha loves eating candies. She has been given N boxes of Candies.
 *
 * She decides that every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
 * Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. Can you find how many candies she will eat?
 *
 * NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).
 *
 * NOTE 2: The same box will not be chosen again.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 105
 *
 * 1 <= B <= 106
 *
 *
 *
 * Input Format
 * The first argument is A an Array of Integers, where A[i] is the number of candies in the ith box.
 * The second argument is B, the maximum number of candies Misha like in a box.
 *
 *
 *
 * Output Format
 * Return an integer denoting the number of candies Misha will eat.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 2, 3]
 *  B = 4
 * Input 2:
 *
 *  A = [1, 2, 1]
 *  B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 */
public class MishaAndCandies {
    public int solve(ArrayList<Integer> A, int B) {
        int noOfCandies = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(A);
        while(!pq.isEmpty() && pq.peek()<=B){
            int x = pq.poll();
            noOfCandies = noOfCandies + x/2;
            if(pq.size()>0){
                int y = pq.poll();
                y = y+(x - x/2);
                pq.offer(y);
            }
        }
        return noOfCandies;
    }
}
