class Solution {
    public int[] sortArrayByParity(int[] nums) {
        ArrayList<Integer> evenList= new ArrayList<>();
        ArrayList<Integer>  oddList = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] %2 == 0) {
                evenList.add(nums[i]);
            }
            else oddList.add(nums[i]);
        }
        Collections.sort(evenList);
        Collections.sort(oddList, Collections.reverseOrder());
        evenList.addAll(oddList);

        int[] ans = new int[evenList.size()];

         for (int i =0 ; i < evenList.size(); i++ ) {
            ans[i] = evenList.get(i);
         }
        

        return ans;
    }
}