class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        return dfs(0, 0, nums, target);
    }

    private int dfs(int index, int sum, int[] nums, int target) {

        // Used all numbers
        if (index == nums.length) {

            if (sum == target)
                return 1;

            return 0;
        }

        // Choose +
        int add = dfs(
                index + 1,
                sum + nums[index],
                nums,
                target
        );

        // Choose -
        int subtract = dfs(
                index + 1,
                sum - nums[index],
                nums,
                target
        );

        // Total number of ways
        return add + subtract;
    }
}