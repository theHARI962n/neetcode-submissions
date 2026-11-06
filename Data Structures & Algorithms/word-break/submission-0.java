class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {

                Boolean[] memo = new Boolean[s.length()];

                        return solve(0, s, wordDict, memo);
                            }

                                private boolean solve(int i, String s,
                                                          List<String> wordDict,
                                                                                    Boolean[] memo) {

                                                                                            if (i == s.length()) {
                                                                                                        return true;
                                                                                                                }

                                                                                                                        if (memo[i] != null) {
                                                                                                                                    return memo[i];
                                                                                                                                            }

                                                                                                                                                    for (String word : wordDict) {

                                                                                                                                                                if (s.startsWith(word, i)) {

                                                                                                                                                                                if (solve(i + word.length(), s, wordDict, memo)) {
                                                                                                                                                                                                    memo[i] = true;
                                                                                                                                                                                                                        return true;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                    memo[i] = false;
                                                                                                                                                                                                                                                                            return false;
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                }
