
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();

                    solve(0, target, nums, new ArrayList<>(), result);

                            return result;
                                }

                                    private void solve(int index, int remaining, int[] nums,
                                                           List<Integer> path,
                                                                                  List<List<Integer>> result) {

                                                                                          if (remaining == 0) {
                                                                                                      result.add(new ArrayList<>(path));
                                                                                                                  return;
                                                                                                                          }

                                                                                                                                  if (remaining < 0 || index == nums.length) {
                                                                                                                                              return;
                                                                                                                                                      }

                                                                                                                                                              // Choice 1: Take current number
                                                                                                                                                                      path.add(nums[index]);

                                                                                                                                                                              solve(index, remaining - nums[index],
                                                                                                                                                                                            nums, path, result);

                                                                                                                                                                                                    // Undo the choice (backtrack)
                                                                                                                                                                                                            path.remove(path.size() - 1);

                                                                                                                                                                                                                    // Choice 2: Skip current number
                                                                                                                                                                                                                            solve(index + 1, remaining, nums, path, result);
                                                                                                                                                                                                                                }
                                                                                                                                                       }
