class Solution {

    public int maxProfit(int[] prices) {
        return dfs(0, 0, prices);
    }

    private int dfs(int day, int holding, int[] prices) {

        if (day >= prices.length)
            return 0;

        if (holding == 0) {

            int buy =
                    -prices[day]
                    + dfs(day + 1, 1, prices);

            int skip =
                    dfs(day + 1, 0, prices);

            return Math.max(buy, skip);

        } else {

            int sell =
                    prices[day]
                    + dfs(day + 2, 0, prices);

            int hold =
                    dfs(day + 1, 1, prices);

            return Math.max(sell, hold);
        }
    }
}