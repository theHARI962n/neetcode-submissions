class Solution {
        public int rob(int[] nums) {
                int n = nums.length;

                        // Only one house: take its money.
                                if (n == 1) {
                                            return nums[0];
                                                    }

                                                            int excludeLast = robRange(nums, 0, n - 2);
                                                                    int excludeFirst = robRange(nums, 1, n - 1);

                                                                            return Math.max(excludeLast, excludeFirst);
                                                                                }

                                                                                    private int robRange(int[] nums, int start, int end) {
                                                                                            int count = end - start + 1;

                                                                                                    // dp[i] = best amount from the first i houses
                                                                                                            // within this range.
                                                                                                                    int[] dp = new int[count + 1];

                                                                                                                            dp[0] = 0;
                                                                                                                                    dp[1] = nums[start];

                                                                                                                                            for (int i = 2; i <= count; i++) {
                                                                                                                                                        int currentIndex = start + i - 1;

                                                                                                                                                                    int skip = dp[i - 1];
                                                                                                                                                                                int take = nums[currentIndex] + dp[i - 2];

                                                                                                                                                                                            dp[i] = Math.max(skip, take);
                                                                                                                                                                                                    }

                                                                                                                                                                                                            return dp[count];
                                                                                                                                                                                                                }
                                                                                                                                                                                                                }
