class Solution {

    public int dfs(int row, int col, int[][] grid, boolean[][] visited) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Out of bounds, water, or already visited
        if (row < 0 || row >= rows ||
            col < 0 || col >= cols ||
            grid[row][col] == 0 ||
            visited[row][col]) {
            return 0;
        }

        // Mark current cell as visited
        visited[row][col] = true;

        // Count current cell
        int area = 1;

        // Explore all 4 directions
        area += dfs(row - 1, col, grid, visited); // Up
        area += dfs(row + 1, col, grid, visited); // Down
        area += dfs(row, col - 1, grid, visited); // Left
        area += dfs(row, col + 1, grid, visited); // Right

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1 && !visited[i][j]) {

                    int currentArea = dfs(i, j, grid, visited);

                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;
    }
}