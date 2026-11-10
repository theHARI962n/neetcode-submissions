

class Solution {

    public List<List<Integer>> combinationSum2(
                int[] candidates, int target) {

                        List<List<Integer>> result = new ArrayList<>();

                                Arrays.sort(candidates);

                                        backtrack(0, target, candidates,
                                                          new ArrayList<>(), result);

                                                                  return result;
                                                                      }

                                                                          private void backtrack(int start, int remaining,
                                                                                                     int[] candidates,
                                                                                                                                List<Integer> path,
                                                                                                                                                           List<List<Integer>> result) {

                                                                                                                                                                   if (remaining == 0) {
                                                                                                                                                                               result.add(new ArrayList<>(path));
                                                                                                                                                                                           return;
                                                                                                                                                                                                   }

                                                                                                                                                                                                           for (int i = start; i < candidates.length; i++) {

                                                                                                                                                                                                                       // Skip duplicate choices at this level
                                                                                                                                                                                                                                   if (i > start &&
                                                                                                                                                                                                                                                   candidates[i] == candidates[i - 1]) {
                                                                                                                                                                                                                                                                   continue;
                                                                                                                                                                                                                                                                               }

                                                                                                                                                                                                                                                                                           // Sorted array: later numbers are also too large
                                                                                                                                                                                                                                                                                                       if (candidates[i] > remaining) {
                                                                                                                                                                                                                                                                                                                       break;
                                                                                                                                                                                                                                                                                                                                   }

                                                                                                                                                                                                                                                                                                                                               // Choose
                                                                                                                                                                                                                                                                                                                                                           path.add(candidates[i]);

                                                                                                                                                                                                                                                                                                                                                                       // Explore using the next index
                                                                                                                                                                                                                                                                                                                                                                                   backtrack(i + 1,
                                                                                                                                                                                                                                                                                                                                                                                                         remaining - candidates[i],
                                                                                                                                                                                                                                                                                                                                                                                                                               candidates, path, result);

                                                                                                                                                                                                                                                                                                                                                                                                                                           // Undo
                                                                                                                                                                                                                                                                                                                                                                                                                                                       path.remove(path.size() - 1);
                                                                                                                                                                                                                                                                                                                                                                                                                                                               }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                   }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                   }

