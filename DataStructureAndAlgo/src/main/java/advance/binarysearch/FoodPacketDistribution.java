package advance.binarysearch;

import java.util.ArrayList;

/**
 * Food Packets Distribution
 * Problem Description
 * The government wants to set up B distribution offices across N cities for the distribution of food
 * packets. The population of the ith city is A[i]. Each city must have at least 1 office, and people can go to an office of their own city. We want to maximize the minimum number of people who can get food in any single office.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 106
 *
 * 1 <= B <= 5 x 105
 *
 *
 *
 * Input Format
 * The first line of input contains an integer array A.
 *
 * The second line of input contains an integer B.
 *
 *
 *
 * Output Format
 * Return one integer representing the maximum number of people who can get food in any single office.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *   A = [10000, 20000, 30000]
 *   B = 6
 * Input 2:
 *
 *   A = [1, 1, 1]
 *   B = 4
 *
 *
 * Example Output
 * Output 1:
 *
 *   10000
 * Output 2:
 *
 *   0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *   1 office can be opened in the first city,
 *   2 offices in the second city and
 *   3 in the third. This way ,
 *   10,000 people can get food in the office in the first city, and
 *   10,000 people can get food in each office in the second city and
 *   10,000 people can get food in third city.
 *   We will allot 10000 people in each office in the third city.
 *   Had we alloted more in some office, we had to allot lesser in some other office which will reduce the answer.
 * Explanation 2:
 *
 *   We will have to allot 2 offices to one city. And one of these offices would give food to 0 people.
 *
 */
public class FoodPacketDistribution {
    public int solve(ArrayList<Integer> A, int B) {
        //Find the max population
        int ans = 0;
        int max = Integer.MAX_VALUE;
        long totalPopulation = 0;
        int min = 1;

        for(int i=0;i<A.size();i++){
            max = Math.min(max,A.get(i));
            totalPopulation = totalPopulation + A.get(i);
        }
        if(B > totalPopulation) return 0;
        while(min<=max){
            int mid = min + (max-min)/2;
            if(checkOfficeAvailable(A,B,mid)){
                ans = mid;
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        return ans;
    }

    public boolean checkOfficeAvailable(ArrayList<Integer> A, int officeAvailable, int mid){
        int totalOfficeRequired = 0;
        for(int i=0;i<A.size();i++){
            totalOfficeRequired = totalOfficeRequired +  A.get(i)/mid;
        }
        return totalOfficeRequired >= officeAvailable;
    }
}
