// with visited array 
class Solution {

    public void dfs(
        char[][] grid,
        int row,
        int col,
        boolean[][] visited
    ) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Outside the grid boundaries
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        // Return if it's water ('0') OR if we have already visited this cell
        if (grid[row][col] == '0' || visited[row][col]) {
            return;
        }

        // Mark the current cell as visited in our tracking array
        visited[row][col] = true;

        // Traverse in all 4 directions
        dfs(grid, row - 1, col, visited); // Up
        dfs(grid, row + 1, col, visited); // Down
        dfs(grid, row, col - 1, visited); // Left
        dfs(grid, row, col + 1, visited); // Right
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If it's land and we haven't visited it yet, it's a new island
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    islands++; // Increment ONCE per whole connected island
                }
            }
        }

        return islands;
    }
}