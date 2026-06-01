class Solution {
    public int longestConsecutive(int[] nums) {
        // int n  = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int maxlen = 0;
     
        for(int num : nums){
            if(!set.contains(num - 1)){
                int len = 1;
                int curr = num;
                while(set.contains(curr+1)){
                    len = len+1;
                    curr++;
                }
                maxlen = Math.max(maxlen , len);     
            }
            
        }
        return maxlen;
    }
}
