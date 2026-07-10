class Solution {
    public int majorityElement(int[] nums) {
        int champion = 0;
        int score = 0;
        for (int i = 0 ; i <= nums.length-1 ; i++ ) {
            if(score == 0) {
                champion = nums[i];
                score = 1;
            } else if(nums[i] == champion ){
                score ++;
            } else {
                score--;
            }
            
        }
        return champion;
    }
}