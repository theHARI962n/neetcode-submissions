class Solution {

    public boolean canPartition(int[] nums) {

        int total = 0;

        for(int num : nums)
            total += num;

        // Odd total can never be split equally
        if(total % 2 != 0)
            return false;

        int target = total / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        // Sum 0 is always possible
        for(int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++) {

            for(int sum = 1; sum <= target; sum++) {

                boolean notTake = dp[i - 1][sum];

                boolean take = false;

                if(nums[i - 1] <= sum) {
                    take = dp[i - 1][sum - nums[i - 1]];
                }

                dp[i][sum] = take || notTake;
            }
        }

        return dp[n][target];
    }
}