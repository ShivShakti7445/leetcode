class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n= obstacleGrid[0].length;
        int dp[][]=new int [m][n];
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else if(i==0&&j==0) dp[i][j]=1;
                else {
                    int up = (i > 0) ? dp[i - 1][j] : 0;  // Check if up is valid
                    int dwn = (j > 0) ? dp[i][j - 1] : 0;  // Check if left is valid
                    dp[i][j] = up + dwn;
                }
            }
          }
      return dp[m-1][n-1];
    }
}
