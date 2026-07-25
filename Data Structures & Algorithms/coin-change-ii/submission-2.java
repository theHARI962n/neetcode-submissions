// correct code ( recursion -> top down )
class Solution {

    public int change(int amount, int[] coins) {
        return dfs(0, amount, coins);
    }

    private int dfs(int index, int amount, int[] coins) {

        if (amount == 0)
            return 1;

        if (index == coins.length)
            return 0;

        int take = 0;

        if (coins[index] <= amount) {
            take = dfs(index, amount - coins[index], coins);
        }

        int skip = dfs(index + 1, amount, coins);

        return take + skip;
    }
}