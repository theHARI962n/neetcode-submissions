class Solution {

    Integer[][] dp;

    public int maxProfit(int[] prices) {

        dp = new Integer[prices.length][2];

        return dfs(0, 0, prices);
    }

    private int dfs(int day, int holding, int[] prices) {

        if (day >= prices.length)
            return 0;

        if (dp[day][holding] != null)
            return dp[day][holding];

        int ans;

        if (holding == 0) {

            int buy =
                    -prices[day]
                    + dfs(day + 1, 1, prices);

            int skip =
                    dfs(day + 1, 0, prices);

            ans = Math.max(buy, skip);

        } else {

            int sell =
                    prices[day]
                    + dfs(day + 2, 0, prices);

            int hold =
                    dfs(day + 1, 1, prices);

            ans = Math.max(sell, hold);
        }

        dp[day][holding] = ans;

        return ans;
    }
}