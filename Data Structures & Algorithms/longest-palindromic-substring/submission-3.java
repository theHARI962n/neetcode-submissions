class Solution {
    private int start;
    private int maxLength;

    public String longestPalindrome(String s) {
        start = 0;
        maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);       // Odd-length palindromes
            expand(s, i, i + 1);   // Even-length palindromes
        }

        return s.substring(start, start + maxLength);
    }

    private void expand(String s, int left, int right) {
        while (left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            int currentLength = right - left + 1;

            if (currentLength > maxLength) {
                start = left;
                maxLength = currentLength;
            }

            left--;
            right++;
        }
    }
}