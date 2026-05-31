class Solution {

    boolean predicate(int mid, int[][] matrix, int target) {

        int cols = matrix[0].length;

        int row = mid / cols;
        int col = mid % cols;

        return matrix[row][col] >= target;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int total = rows * cols;

        int L = -1;
        int R = total;

        while (R - L > 1) {

            int M = (L + R) / 2;

            if (!predicate(M, matrix, target)) {
                L = M;
            } else {
                R = M;
            }
        }

        if (R == total) {
            return false;
        }

        int row = R / cols;
        int col = R % cols;

        return matrix[row][col] == target;
    }
}