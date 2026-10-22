

class Solution {
    public int rob(int[] nums) {
            int n = nums.length;

                    if (n == 1) {
                                return nums[0];
                                        }

                                                // Available indexes: 0 through n - 2
                                                        int excludeLast = robRange(nums, 0, n - 2);

                                                                // Available indexes: 1 through n - 1
                                                                        int excludeFirst = robRange(nums, 1, n - 1);

                                                                                return Math.max(excludeLast, excludeFirst);
                                                                                    }

                                                                                        private int robRange(int[] nums, int start, int end) {
                                                                                                int count = end - start + 1;

                                                                                                        int[] dp = new int[count + 1];
                                                                                                                Arrays.fill(dp, -1);

                                                                                                                        return solve(count, start, nums, dp);
                                                                                                                            }

                                                                                                                                private int solve(int i, int start, int[] nums, int[] dp) {
                                                                                                                                        if (i == 0) {
                                                                                                                                                    return 0;
                                                                                                                                                            }

                                                                                                                                                                    if (i == 1) {
                                                                                                                                                                                return nums[start];
                                                                                                                                                                                        }

                                                                                                                                                                                                if (dp[i] != -1) {
                                                                                                                                                                                                            return dp[i];
                                                                                                                                                                                                                    }

                                                                                                                                                                                                                            int skip = solve(i - 1, start, nums, dp);

                                                                                                                                                                                                                                    int take = nums[start + i - 1]
                                                                                                                                                                                                                                                     + solve(i - 2, start, nums, dp);

                                                                                                                                                                                                                                                             dp[i] = Math.max(skip, take);

                                                                                                                                                                                                                                                                     return dp[i];
                                                                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                                                         }