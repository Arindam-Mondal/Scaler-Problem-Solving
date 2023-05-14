package advance.binarysearch;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 *
 * Return the single element that appears only once.
 *
 * Your solution must run in O(log n) time and O(1) space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 *
 * Ref : https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 */
public class SingleElementInSortedArray {
    int duplicate = 0;
    public int singleNonDuplicate(int[] nums) {
        search(nums,0,nums.length-1);
        return duplicate;
    }
    public void search(int[] nums, int l, int h){
        if(l>h){
            return;
        }
        if(l==h){
            duplicate = nums[l];
            return;
        }
        int mid = (l+h)/2;
        if(mid%2 == 0){
            if(nums[mid] == nums[mid+1]){
                search(nums,mid+2,h);
            }else{
                search(nums,l,mid);
            }
        }else if(mid%2 == 1){
            if(nums[mid] == nums[mid-1]){
                search(nums,mid+1,h);
            }else{
                search(nums,l,mid-1);
            }
        }
    }
}
