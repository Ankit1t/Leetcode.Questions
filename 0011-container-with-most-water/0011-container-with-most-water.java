class Solution {
    public int maxArea(int[] height) {
         int left = 0;
        int right = height.length-1;
       int Area = 0;
       while(left < right ) {
        int low = Math.min(height[left], height[right]);
        int distance  = right - left ;
        int area = low * distance;
        Area = Math.max(Area , area ) ;
        if(height[left] < height[right] ) {
            left ++ ;

        }
        else {
            right-- ;
        }
       }
       return Area;
    }
}