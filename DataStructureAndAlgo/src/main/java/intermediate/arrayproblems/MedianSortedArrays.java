package intermediate.arrayproblems;

/**
 * Median of Two Sorted Arrays
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = n+m;
        int[] merged = new int[k];

        int i=0;
        int j=0;
        int l=0;

        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                merged[l] = nums1[i];
                i++;
            }else{
                merged[l] = nums2[j];
                j++;
            }
            l++;
        }

        for(int x=i;x<m;x++){
            merged[l]=nums1[x];
            l++;
        }
        for(int x=j;x<n;x++){
            merged[l]=nums2[x];
            l++;
        }
        int mid = merged.length/2;
        double result = 0.0;
        if(merged.length%2==0){
            result = merged[mid] + merged[mid-1];
            result = result/2;
        }else{
            result = merged[mid];
        }
        return result;

    }
}
