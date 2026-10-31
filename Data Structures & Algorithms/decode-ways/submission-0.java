//Top-down 
class Solution {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(0, s, dp);
    }

    private int solve(int i, String s, int[] dp) {

        // Successfully decoded entire string
        if (i == s.length()) {
            return 1;
        }

        // A decoding cannot start with 0
        if (s.charAt(i) == '0') {
            return 0;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        // Choice 1: Take one digit
        int ways = solve(i + 1, s, dp);

        // Choice 2: Take two digits
        if (i + 1 < s.length()) {

            int num = (s.charAt(i) - '0') * 10
                    + (s.charAt(i + 1) - '0');

            if (num >= 10 && num <= 26) {
                ways += solve(i + 2, s, dp);
            }
        }

        return dp[i] = ways;
    }
}