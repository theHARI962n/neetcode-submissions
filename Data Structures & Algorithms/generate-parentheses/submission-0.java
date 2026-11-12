

class Solution {
    public List<String> generateParenthesis(int n) {

            List<String> result = new ArrayList<>();

                    backtrack(0, 0, n, "", result);

                            return result;
                                }

                                    private void backtrack(int open, int close, int n,
                                                               String current, List<String> result) {

                                                                       // Base case: all n pairs have been used
                                                                               if (open == n && close == n) {
                                                                                           result.add(current);
                                                                                                       return;
                                                                                                               }

                                                                                                                       // Choice 1: Add an opening bracket
                                                                                                                               if (open < n) {
                                                                                                                                           backtrack(open + 1, close, n,
                                                                                                                                                                 current + "(", result);
                                                                                                                                                                         }

                                                                                                                                                                                 // Choice 2: Add a closing bracket
                                                                                                                                                                                         if (close < open) {
                                                                                                                                                                                                     backtrack(open, close + 1, n,
                                                                                                                                                                                                                           current + ")", result);
                                                                                                                                                                                                                                   }
                                                                                                                                                                                                                                       }
                                                                                                                                                                                                                                       }
