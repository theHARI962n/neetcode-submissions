class Solution {
    public int[] productExceptSelf(int[] nums) {
                int n = nums.length;

        int[] res = new int[n];

        int prefix = 1;

        // prefix pass
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;

        // suffix pass from right side
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }
}  



   
