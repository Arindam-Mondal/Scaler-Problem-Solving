package advance.arrays;


import java.util.ArrayList;

/**
 *
 * Merge Intervals
 *
 * Problem Description
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 *
 *
 * Problem Constraints
 * 0 <= |intervals| <= 105
 *
 *
 *
 * Input Format
 * First argument is the vector of intervals
 *
 * second argument is the new interval to be merged
 *
 *
 *
 * Output Format
 * Return the vector of intervals after merging
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 * Input 2:
 *
 * Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
 *
 *
 * Example Output
 * Output 1:
 *
 *  [ [1, 5], [6, 9] ]
 * Output 2:
 *
 *  [ [1, 9] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * (2,5) does not completely merge the given intervals
 * Explanation 2:
 *
 * (2,6) completely merges the given intervals
 */
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
  }

public class MergeIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval.start > newInterval.end){
            int temp = newInterval.end;
            newInterval.end = newInterval.start;
            newInterval.start = temp;
        }
        ArrayList<Interval> finalIntervals = new ArrayList<>();
        int n = intervals.size();
        for(int i=0;i<n;i++){
            Interval currentInterval = intervals.get(i);
            if(currentInterval.start > newInterval.end){
                finalIntervals.add(newInterval);
                while(i<n){
                    finalIntervals.add(intervals.get(i));
                    i++;
                }
                return finalIntervals;
            }else if(newInterval.start > currentInterval.end){
                finalIntervals.add(currentInterval);
            }else if((newInterval.start >= currentInterval.start && newInterval.start<=currentInterval.end) || (newInterval.end >= currentInterval.start && newInterval.end<=currentInterval.end)){
                newInterval.start = Math.min(newInterval.start,currentInterval.start);
                newInterval.end = Math.max(newInterval.end,currentInterval.end);
            }
        }
        if(n==0 || newInterval.end >= intervals.get(n-1).end){
            finalIntervals.add(newInterval);
        }
        return finalIntervals;

    }
}
