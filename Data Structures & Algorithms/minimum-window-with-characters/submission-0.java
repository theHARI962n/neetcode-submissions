class Solution {
    public String minWindow(String s, String t) {

        // Frequency map for characters needed
        HashMap<Character, Integer> need = new HashMap<>();

        // Frequency map for current window
        HashMap<Character, Integer> window = new HashMap<>();

        // Build the need map
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int required = need.size();   // Number of unique characters needed
        int formed = 0;               // Number of unique characters currently satisfied

        int left = 0;

        // Variables to store the best answer
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        // Expand the window
        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // Add current character to window
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Check if this character just became satisfied
            if (need.containsKey(c) &&
                window.get(c).equals(need.get(c))) {
                formed++;
            }

            // Try to shrink while window is valid
            while (formed == required) {

                // Update best answer
                int windowLength = right - left + 1;

                if (windowLength < minLength) {
                    minLength = windowLength;
                    startIndex = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // Did removing it break the requirement?
                if (need.containsKey(leftChar) &&
                    window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startIndex, startIndex + minLength);
    }
}