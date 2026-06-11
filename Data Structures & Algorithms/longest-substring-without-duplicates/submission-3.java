class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int maxlen = 0;
        
        for(int i = 0; i<s.length(); i++){
            HashSet<Character> set = new HashSet<>();
            int len = 0;
            for(int j = i;j<s.length(); j++){
                if(set.contains(s.charAt(j))){
                    break;
                }
                set.add(s.charAt(j));
                len++;
            }
            maxlen = Math.max(maxlen,len);
        }
        return maxlen;   
    }
}
