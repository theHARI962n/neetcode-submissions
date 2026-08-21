//

class Solution {
        public void rotate(int[][] matrix) {

                int n = matrix.length;

                        // Go through each layer
                                for (int layer = 0; layer < n / 2; layer++) {

                                            // Go through each element in the current layer
                                                        for (int i = layer; i < n - 1 - layer; i++) {

                                                                        // Save the top value
                                                                                        int temp = matrix[layer][i];

                                                                                                        // Left -> Top
                                                                                                                        matrix[layer][i] =
                                                                                                                                                matrix[n - 1 - i][layer];

                                                                                                                                                                // Bottom -> Left
                                                                                                                                                                                matrix[n - 1 - i][layer] =
                                                                                                                                                                                                        matrix[n - 1 - layer][n - 1 - i];

                                                                                                                                                                                                                        // Right -> Bottom
                                                                                                                                                                                                                                        matrix[n - 1 - layer][n - 1 - i] =
                                                                                                                                                                                                                                                                matrix[i][n - 1 - layer];

                                                                                                                                                                                                                                                                                // Top -> Right
                                                                                                                                                                                                                                                                                                matrix[i][n - 1 - layer] = temp;
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                 }
