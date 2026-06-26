class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> freq = new HashMap<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            while ((right - left + 1) - getMaxFreq(freq) > k) {

                char leftChar = s.charAt(left);

                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0)
                    freq.remove(leftChar);

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    private int getMaxFreq(HashMap<Character, Integer> freq) {

        int max = 0;

        for (int value : freq.values()) {
            max = Math.max(max, value);
        }

        return max;
    }
}