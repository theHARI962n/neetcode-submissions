class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(current));

        // Recursively generate subsets
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]); // Include the element

            generateSubsets(nums, i + 1, current, result); // Recurse

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}

