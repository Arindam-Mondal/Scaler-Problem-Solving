package advance.binarysearch;

import java.util.ArrayList;

/**
 * Aggressive cows
 *
 * Problem Description
 * Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
 *
 * His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
 *
 *
 *
 * Problem Constraints
 * 2 <= N <= 100000
 * 0 <= A[i] <= 109
 * 2 <= B <= N
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return the largest minimum distance possible among the cows.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * B = 3
 * Input 2:
 *
 * A = [1, 2]
 * B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
 * Explanation 2:
 *
 *  The minimum distance will be 1.
 */
public class AggressiveCows {
    public int solve(ArrayList<Integer> A, int B) {
        A.sort((a,b)->a.compareTo(b));
        int low = 1;
        int high = A.get(A.size()-1);
        int ans = low;
        while(low<=high){
            int mid = low + (high-low)/2;
            //If we are able to fit all the cows in the range we will increase our search space and look for next higher distance.
            if(check(A,mid,B)){
                ans = mid;
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return ans;
    }

    //This method is to check how many cows are getting fit if the min distance is mid.
    public boolean check(ArrayList<Integer> A, int mid, int B){
        int prev = A.get(0);
        int count = 1;
        for(int i=1;i<A.size();i++){
            if(A.get(i)-prev >=mid){
                prev = A.get(i);
                count++;
            }
            if(count == B){
                return true;
            }
        }
        return false;
    }
}
