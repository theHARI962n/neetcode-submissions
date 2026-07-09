class Solution {

    int[][] dp;

    public int change(int amount, int[] coins) {

        dp = new int[coins.length][amount + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, amount, coins);
    }

    private int solve(int index, int amount, int[] coins) {

        if (amount == 0)
            return 1;

        if (index == coins.length)
            return 0;

        if (dp[index][amount] != -1)
            return dp[index][amount];

        int include = 0;

        if (coins[index] <= amount) {
            include = solve(index, amount - coins[index], coins);
        }

        int exclude = solve(index + 1, amount, coins);

        dp[index][amount] = include + exclude;

        return dp[index][amount];
    }
}