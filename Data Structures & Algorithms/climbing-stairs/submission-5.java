// more optimized verion (space optimized)
class Solution {
    public int climbStairs(int n) {
        if( n < 0 ) return 0;

        int prev2 = 1; // dp[0]
        int prev1 = 1; // dp[1]

        for(int i = 2; i<=n ; i++){
            int curr = prev2 + prev1;

            prev2 = prev1;
            prev1 = curr;

        }
        
        return prev1;
    
}
}
