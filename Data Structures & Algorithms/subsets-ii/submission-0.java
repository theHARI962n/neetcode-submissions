
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

            List<List<Integer>> result = new ArrayList<>();

                    Arrays.sort(nums);

                            backtrack(0, nums, new ArrayList<>(), result);

                                    return result;
                                        }

                                            private void backtrack(int start, int[] nums,
                                                                       List<Integer> path,
                                                                                                  List<List<Integer>> result) {

                                                                                                          // Every current path is a valid subset
                                                                                                                  result.add(new ArrayList<>(path));

                                                                                                                          for (int i = start; i < nums.length; i++) {

                                                                                                                                      // Skip duplicates at the same level
                                                                                                                                                  if (i > start && nums[i] == nums[i - 1]) {
                                                                                                                                                                  continue;
                                                                                                                                                                              }

                                                                                                                                                                                          // Choose
                                                                                                                                                                                                      path.add(nums[i]);

                                                                                                                                                                                                                  // Explore
                                                                                                                                                                                                                              backtrack(i + 1, nums, path, result);

                                                                                                                                                                                                                                          // Undo
                                                                                                                                                                                                                                                      path.remove(path.size() - 1);
                                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                                  }
