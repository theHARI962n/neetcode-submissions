//Bottum up
class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        for (int day = n - 1; day >= 0; day--) {

            // holding = 0
            int buy = -prices[day] + dp[day + 1][1];
            int skip = dp[day + 1][0];

            dp[day][0] = Math.max(buy, skip);

            // holding = 1
            int sell = prices[day] + dp[day + 2][0];
            int hold = dp[day + 1][1];

            dp[day][1] = Math.max(sell, hold);
        }

        return dp[0][0];
    }
}