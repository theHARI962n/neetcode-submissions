class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        backtrack(nums, current, used, result);

        return result;
    }

    private void backtrack(
            int[] nums,
            List<Integer> current,
            boolean[] used,
            List<List<Integer>> result) {

        // Complete permutation
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every number
        for (int i = 0; i < nums.length; i++) {

            // Already used
            if (used[i]) {
                continue;
            }

            // Choose
            current.add(nums[i]);
            used[i] = true;

            // Explore
            backtrack(nums, current, used, result);

            // Undo
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}