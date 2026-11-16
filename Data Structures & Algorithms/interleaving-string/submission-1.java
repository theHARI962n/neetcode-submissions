
class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {

            int n = s1.length();
                    int m = s2.length();

                            if (n + m != s3.length()) {
                                        return false;
                                                }

                                                        Boolean[][] memo = new Boolean[n + 1][m + 1];

                                                                return solve(0, 0, s1, s2, s3, memo);
                                                                    }

                                                                        private boolean solve(int i, int j,
                                                                                                  String s1, String s2, String s3,
                                                                                                                            Boolean[][] memo) {

                                                                                                                                    if (i == s1.length() && j == s2.length()) {
                                                                                                                                                return true;
                                                                                                                                                        }

                                                                                                                                                                if (memo[i][j] != null) {
                                                                                                                                                                            return memo[i][j];
                                                                                                                                                                                    }

                                                                                                                                                                                            int k = i + j;

                                                                                                                                                                                                    boolean ans = false;

                                                                                                                                                                                                            if (i < s1.length() &&
                                                                                                                                                                                                                        s1.charAt(i) == s3.charAt(k)) {

                                                                                                                                                                                                                                    ans = solve(i + 1, j, s1, s2, s3, memo);
                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                    if (!ans &&
                                                                                                                                                                                                                                                                j < s2.length() &&
                                                                                                                                                                                                                                                                            s2.charAt(j) == s3.charAt(k)) {

                                                                                                                                                                                                                                                                                        ans = solve(i, j + 1, s1, s2, s3, memo);
                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                        memo[i][j] = ans;

                                                                                                                                                                                                                                                                                                                return ans;
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                    