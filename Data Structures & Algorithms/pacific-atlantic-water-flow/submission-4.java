// dfs

class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Start DFS from Pacific borders
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific);
            dfs(heights, r, cols - 1, atlantic);
        }

        // Start DFS from Atlantic borders
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific);
            dfs(heights, rows - 1, c, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();

        // Cell reachable from both oceans
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(
            int[][] heights,
            int r,
            int c,
            boolean[][] ocean
    ) {

        // Already visited
        if (ocean[r][c]) {
            return;
        }

        ocean[r][c] = true;

        int[][] directions = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
        };

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            // Out of bounds
            if (nr < 0 || nr >= heights.length ||
                nc < 0 || nc >= heights[0].length) {
                continue;
            }

            // Reverse flow:
            // We can move from current cell to neighbor
            // only if neighbor's height >= current height.
            if (heights[nr][nc] >= heights[r][c]) {
                dfs(heights, nr, nc, ocean);
            }
        }
    }
}