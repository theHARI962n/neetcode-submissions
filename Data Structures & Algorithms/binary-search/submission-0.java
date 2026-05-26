class Solution {

    public int search(int[] nums, int target) {

        int n = nums.length;

        int l = -1;
        int r = n;

        while (r - l > 1) {

            int mid = l + (r - l) / 2;

            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid;
            }
        }

        // verify target exists
        if (r < n && nums[r] == target) {
            return r;
        }

        return -1;
    }
}