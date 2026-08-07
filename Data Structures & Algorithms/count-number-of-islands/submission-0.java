class Solution {
    public void dfs(char[][] grid, int row, int col) {

    int rows = grid.length;
    int cols = grid[0].length;

    // Outside the grid
    if (row < 0 || row >= rows || col < 0 || col >= cols)
        return;

    // Water or already visited
    if (grid[row][col] != '1')
        return;

    // Mark visited
    grid[row][col] = '0';

    dfs(grid, row - 1, col); // Up
    dfs(grid, row + 1, col); // Down
    dfs(grid, row, col - 1); // Left
    dfs(grid, row, col + 1); // Right
}

    public int numIslands(char[][] grid) {

    int islands = 0;

    for (int i = 0; i < grid.length; i++) {

        for (int j = 0; j < grid[0].length; j++) {

            if (grid[i][j] == '1') {

                dfs(grid, i, j);

                islands++;

            }
        }
    }

    return islands;
}
}