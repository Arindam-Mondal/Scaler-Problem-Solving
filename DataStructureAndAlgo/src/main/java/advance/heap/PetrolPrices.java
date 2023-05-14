package advance.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * Rishik goes to IB office on N days on his bike which consumes exactly 1 litre of petrol every day but his bike can only store at max B liters of petrol.
 * You are given petrol prices for all N days as integer array A.
 * Find the minimum cost that could occur to Rishik if he chooses optimal quantity to refuel everyday.
 *
 * Note :
 * refueling station is very very close to Rishik's home. So, he can reach there from home at 0 petrol. But he cannot go to office with 0 fuel.
 * Initially, the bike has 0 fuel.
 *
 * problem Constarints :
 * 1<=B<=N<=100000
 * 1<=A[i]<= 20000
 *
 * First Argument contains an integer array A denoting petrol prices for N days
 * Second Argument contains an integer B denoting Bike capacity.
 *
 * Output format
 *
 * Returns a single integer denoting minimum cost.
 *
 * Example Input
 *
 * Input1:
 *
 * A = [5,6,3,4,2,1]
 * B = 2
 *
 * Input 2:
 *
 * A = [7,3,3,5,2]
 * B = 3
 *
 * Output 1 = 19
 *
 *
 * Example explanation :
 *
 * Explanation 1:
 *
 * Quantity of petrol filled each day = [2,0,2,0,1,1] This gives the minimum cost
 *
 */

public class PetrolPrices {
    public class Solution {
        public int solve(ArrayList<Integer> A, int B) {
            //use min heap to solve this problem
            PriorityQueue<Pair> pq = new PriorityQueue<>(new CustomComparator());
            int minCost = 0;
            for(int i=0;i<A.size();i++){
                Pair p = new Pair(A.get(i),i);
                pq.offer(p);
                while(pq.peek().index <= (i-B)){
                    pq.poll();
                }
                minCost = minCost + pq.peek().value;
            }
            return minCost;
        }
        class Pair{
            int value;
            int index;
            Pair(int value,int index){
                this.value = value;
                this.index = index;
            }
        }

        class CustomComparator implements Comparator<Pair> {

            public int compare(Pair a, Pair b)
            {
                return a.value - b.value;
            }
        }
    }
}
