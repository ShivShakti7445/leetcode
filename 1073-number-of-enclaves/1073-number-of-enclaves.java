class Solution {
      class pair {
        int first;
        int second;
        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
      }
public int numEnclaves(int[][] grid) {
            int ans=0;
            int n = grid.length;
            if (n == 0) return 0; 
            int m = grid[0].length;

        Queue<pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ( (i == 0 || i == n - 1 || j == 0 || j == m - 1) &&grid[i][j] == 1) {
                    q.add(new pair(i, j));
                    grid[i][j] = '#';
                }
            }
        } 
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;

            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1) {
                    q.add(new pair(nrow, ncol));
                    grid[nrow][ncol] = '#';  
                }
             }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans++;
                } 
            }
        }

    return ans;
  }
}

