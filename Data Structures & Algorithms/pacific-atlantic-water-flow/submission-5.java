// bfs code 
import java.util.*;

class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // Pacific: top row + left column
        for (int r = 0; r < rows; r++) {
            pacificQueue.offer(new int[]{r, 0});
            pacific[r][0] = true;
        }

        for (int c = 0; c < cols; c++) {
            pacificQueue.offer(new int[]{0, c});
            pacific[0][c] = true;
        }

        // Atlantic: bottom row + right column
        for (int r = 0; r < rows; r++) {
            atlanticQueue.offer(new int[]{r, cols - 1});
            atlantic[r][cols - 1] = true;
        }

        for (int c = 0; c < cols; c++) {
            atlanticQueue.offer(new int[]{rows - 1, c});
            atlantic[rows - 1][c] = true;
        }

        // BFS from both oceans
        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        List<List<Integer>> result = new ArrayList<>();

        // Cells reachable from BOTH oceans
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void bfs(
            int[][] heights,
            Queue<int[]> queue,
            boolean[][] visited
    ) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] directions = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                // Out of bounds
                if (nr < 0 || nr >= rows ||
                    nc < 0 || nc >= cols) {
                    continue;
                }

                // Already visited
                if (visited[nr][nc]) {
                    continue;
                }

                // Reverse water flow
                if (heights[nr][nc] < heights[r][c]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}