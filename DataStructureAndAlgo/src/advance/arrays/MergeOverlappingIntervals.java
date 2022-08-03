package advance.arrays;

import java.util.ArrayList;

/**
 *  Merge Overlapping Intervals
 *
 *  Problem Description
 * Given a collection of intervals, merge all overlapping intervals.
 *
 *
 *
 * Problem Constraints
 * 1 <= Total number of intervals <= 100000.
 *
 *
 *
 * Input Format
 * First argument is a list of intervals.
 *
 *
 *
 * Output Format
 * Return the sorted list of intervals after merging all the overlapping intervals.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * [1,3],[2,6],[8,10],[15,18]
 *
 *
 * Example Output
 * Output 1:
 *
 * [1,6],[8,10],[15,18]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Merge intervals [1,3] and [2,6] -> [1,6].
 * so, the required answer after merging is [1,6],[8,10],[15,18].
 * No more overlapping intervals present.
 */
public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        //firts sort the array ArrayList
        intervals.sort((a,b)->Integer.valueOf(a.start).compareTo(Integer.valueOf(b.start)));
        ArrayList<Interval> finalList = new ArrayList<>();
        finalList.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            if(finalList.get(finalList.size()-1).end >= intervals.get(i).start){
                finalList.get(finalList.size()-1).start = Math.min(finalList.get(finalList.size()-1).start,intervals.get(i).start);
                finalList.get(finalList.size()-1).end = Math.max(finalList.get(finalList.size()-1).end,intervals.get(i).end);
            }else{
                finalList.add(intervals.get(i));
            }
        }
        return finalList;
    }
}
