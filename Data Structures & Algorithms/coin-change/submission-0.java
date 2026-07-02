class Solution {
    public int coinChange(int[] coins, int amount) {

    int[] dp = new int[amount + 1];

    // Infinity (a value larger than any possible answer)
    Arrays.fill(dp, amount + 1);

    dp[0] = 0;

    for (int coin : coins) {

        for (int curr = coin; curr <= amount; curr++) {

            dp[curr] = Math.min(
                dp[curr],
                1 + dp[curr - coin]
            );

        }
    }

    return dp[amount] == amount + 1 ? -1 : dp[amount];
}
}
