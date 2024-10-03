// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m=obstacleGrid.length;
//         int n= obstacleGrid[0].length;
//         int dp[][]=new int [m][n];
//          for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(obstacleGrid[i][j]==1) dp[i][j]=0;
//                 else if(i==0&&j==0) dp[i][j]=1;
//                 else {
//                     int up = (i > 0) ? dp[i - 1][j] : 0;  // Check if up is valid
//                     int dwn = (j > 0) ? dp[i][j - 1] : 0;  // Check if left is valid
//                     dp[i][j] = up + dwn;
//                 }
//             }
//           }
//       return dp[m-1][n-1];
//     }
// }

// way 2

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n= obstacleGrid[0].length;
        int dp[][] = new int[m][n];

        // Initialize the first row and first column to 1 as there's only one way to reach those cells.
         for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;  // If there's an obstacle, no paths are possible.
                break;  // No point in continuing as the entire column below will also be blocked.
            } else {
                dp[i][0] = 1;  // If no obstacle, there's one way to reach the cell.
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;  // If there's an obstacle, no paths are possible.
                break;  // No point in continuing as the entire row to the right will also be blocked.
            } else {
                dp[0][j] = 1;  // If no obstacle, there's one way to reach the cell.
            }
        }

        // Fill in the dp array by summing paths from the top and left cells.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else{
                    int up = dp[i-1][j]; // From the top
                    int left = dp[i][j-1]; // From the left
                    dp[i][j] = up + left;
                }
            }
        }

        // Return the number of unique paths to the bottom-right corner.
        return dp[m-1][n-1];
    }
}
