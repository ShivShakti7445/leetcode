import java.util.*;

class Solution {
    // Custom class to represent a node in the queue
    class Triple {
        int distance;
        int row;
        int col;

        Triple(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Edge case: if the start or the end cell is blocked
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }

        // Distance array to keep track of the minimum distance to each cell
        int[][] dis = new int[n][m];
        for (int[] row : dis) {
            Arrays.fill(row, (int) 1e9); // Initialize with large value
        }
        dis[0][0] = 0; // Distance to the starting point is 0

        // Queue to perform BFS
        Queue<Triple> q = new LinkedList<>();
        q.add(new Triple(1, 0, 0)); // Start from (0, 0) with distance 1

        // Directions for moving in 8 possible directions
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

        // Perform BFS
        while (!q.isEmpty()) {
            Triple node = q.poll();
            int currDist = node.distance;
            int r = node.row;
            int c = node.col;

            // If we reached the bottom-right corner
            if (r == n - 1 && c == m - 1) {
                return currDist;
            }

            // Explore all 8 possible directions
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // Check if the new cell is within bounds and is passable
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 0) {
                    if (currDist + 1 < dis[nr][nc]) {
                        dis[nr][nc] = currDist + 1;
                        q.add(new Triple(currDist + 1, nr, nc));
                    }
                }
            }
        }

        // If we finish BFS without reaching the bottom-right corner
        return -1;
    }
}
