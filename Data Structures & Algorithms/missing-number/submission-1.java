class Solution {
    public int missingNumber(int[] nums) {
        int xor = nums.length;

        for(int i = 0; i < nums.length; i++){
            xor ^= i;
            xor ^= nums[i];
        }

        return xor;
    }
} 
// class Solution {
//     public int missingNumber(int[] nums) {
//         int n = nums.length;
//         int ans = 0;
//         for(int i = 0 ; i < n; i++){
//             if(nums[i] != i){
//                 ans = i;
//             }
//         }
//         return ans;
//     }
// }
