
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        int ans = grid[0][0];  // This initialization is not necessary here, but keeping it per the original code
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];  // Starting point
                } else {
                    int up = Integer.MAX_VALUE;  // Default value if out of bounds
                    int dwn = Integer.MAX_VALUE;  // Default value if out of bounds
                    
                    if (i > 0) up = dp[i - 1][j];  // Value from the top cell
                    if (j > 0) dwn = dp[i][j - 1];  // Value from the left cell
                    
                    dp[i][j] = grid[i][j] + Math.min(up, dwn);  // Take the minimum path sum
                }
            }
        }
        
        return dp[m - 1][n - 1];  // Return the bottom-right corner value
    }
}
