class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        for (int right = 0; right < nums.length; right++) {

            // Remove all smaller elements from the back
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] < nums[right]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(right);

            // Remove expired indices from the front
            int left = right - k + 1;

            if (!dq.isEmpty() &&
                dq.peekFirst() < left) {
                dq.pollFirst();
            }

            // Window is complete
            if (right >= k - 1) {
                ans.add(nums[dq.peekFirst()]);
            }
        }

        // Convert List<Integer> to int[]
        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}