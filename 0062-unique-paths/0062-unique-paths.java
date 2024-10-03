
// class Solution {
//     public int uniquePaths(int m, int n) {
//         int dp[][]=new int[m][n];
//         dp[0][0]=1;

//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(i==0 ||j==0) continue;
//                 else{
//                     int up=0;
//                     int down=0;
//                     if(i>1)  {up=dp[i-1][j];}
//                     if(j>1)  {down=dp[i][j-1];}
//                     dp[i][j]=up+down;
//                 }
//             }
//         }
//         return dp[m-1][n-1];
//     }
// }

class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        // Initialize the first row and first column to 1 as there's only one way to reach those cells.
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill in the dp array by summing paths from the top and left cells.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int up = dp[i-1][j]; // From the top
                int left = dp[i][j-1]; // From the left
                dp[i][j] = up + left;
            }
        }

        // Return the number of unique paths to the bottom-right corner.
        return dp[m-1][n-1];
    }
}
