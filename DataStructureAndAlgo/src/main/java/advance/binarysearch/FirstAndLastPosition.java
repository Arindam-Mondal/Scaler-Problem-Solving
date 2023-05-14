package advance.binarysearch;

/**
 * Find First and Last Position of Element in Sorted Array
 * Medium
 * 15.6K
 * 366
 * Companies
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] pos = new int[2];
        pos[0] = -1;
        pos[1] = -1;
        findMin(nums,target,0,nums.length-1,pos);
        findMax(nums,target,0,nums.length-1,pos);
        return pos;
    }

    public void findMin(int[] nums,int target, int left, int right,int[] pos){
        if(left>right){
            return;
        }
        int mid = left + (right-left)/2;
        if(target == nums[mid]){
            pos[0] = mid;
            //again search in left
            findMin(nums,target,left,mid-1,pos);
        }else if(nums[mid]>target){
            findMin(nums,target,left,mid-1,pos);
        }else{
            findMin(nums,target,mid+1,right,pos);
        }
    }

    public void findMax(int[] nums,int target, int left, int right,int[] pos){
        if(left>right){
            return;
        }
        int mid = left + (right-left)/2;
        if(target == nums[mid]){
            pos[1] = mid;
            //again search in left
            findMax(nums,target,mid+1,right,pos);
        }else if(nums[mid]>target){
            findMax(nums,target,left,mid-1,pos);
        }else{
            findMax(nums,target,mid+1,right,pos);
        }
    }
}
