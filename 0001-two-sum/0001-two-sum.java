class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0 ;
     
        while(left < nums.length) {
            int right = left + 1;
            while (right < nums.length) {
            if(nums[left] + nums[right]== target ) {
                return new int[]{left , right};
            
            } 
            right++;
            
        }
        left ++;

        }
        return new int []{};
    }
}