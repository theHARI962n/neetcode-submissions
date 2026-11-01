//Bottum-up
class Solution {
    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1;

        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        // i represents the prefix length
        for (int i = 2; i <= n; i++) {

            // Check the last single digit
            char last = s.charAt(i - 1);

            if (last != '0') {
                // Append this digit to all ways
                // of decoding the first i-1 characters
                dp[i] += dp[i - 1];
            }

            // Check the last two digits
            int num = Integer.parseInt(
                s.substring(i - 2, i)
            );

            if (num >= 10 && num <= 26) {
                // Append this pair to all ways
                // of decoding the first i-2 characters
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}