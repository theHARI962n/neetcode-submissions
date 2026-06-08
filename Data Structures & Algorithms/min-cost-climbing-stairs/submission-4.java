//space optimized
class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int next1 = 0; // dp[i+1]
        int next2 = 0; // dp[i+2]

        for (int i = cost.length - 1; i >= 0; i--) {

            int curr = cost[i] +
                       Math.min(next1, next2);

            next2 = next1;
            next1 = curr;
        }

        return Math.min(next1, next2);
    }
}