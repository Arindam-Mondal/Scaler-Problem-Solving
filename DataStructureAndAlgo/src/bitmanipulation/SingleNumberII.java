package bitmanipulation;

/**
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each element in nums appears exactly three times except for one element which appears once.
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            int count = 0;
            //By XOR - all the elements which are getting repeated will be converted to ) and only the number which is not getting repeated will remain.
            for(int j=i+1;j<nums.length;j++){
                if((nums[j]^x) == 0){
                    // System.out.println(x + " " + nums[j] + " " +((nums[j]^x)==0));
                    nums[j] = 0;
                    nums[i] = 0;
                    count++;
                }
                if(count == 2){
                    break;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                res = nums[i];
            }
        }
        // System.out.println("--------------");
        return res;

    }
}
