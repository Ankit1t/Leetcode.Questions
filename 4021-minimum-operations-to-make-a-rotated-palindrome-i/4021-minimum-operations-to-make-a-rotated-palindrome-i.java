class Solution {
   public int minOperations(String s) {
    int n = s.length();
    int minOps = Integer.MAX_VALUE;

    for (int start = 0; start < n; start++) {
        int currentCost = start;
        for (int i = 0; i < n / 2; i++) {
            char left = s.charAt((start + i) % n);
            char right = s.charAt((start + n - 1 - i) % n);

            int diff = Math.abs(left - right);

           
            int incrementCost = Math.min(diff, 26 - diff);
            currentCost += incrementCost;
        }

        minOps = Math.min(minOps, currentCost);
    }

    return minOps;
}
}