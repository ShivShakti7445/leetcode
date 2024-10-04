// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//          int n=matrix.length;
//          int dp[][]=new int[n][n];
//          for(int j=0;j<n;j++){
//             dp[n-1][j]=matrix[n-1][j];
//          }
//          for(int i=n-2;i>=0;i--){
//             int dyl=Integer.MAX_VALUE;
//             int dyr=Integer.MAX_VALUE;
//             for(int j=n-1;j>=0;j--){
//                  int d=matrix[i][j]+dp[i+1][j];
//                  if(j>0)dyl=matrix[i][j]+dp[i+1][j-1];
//                  if(j<n-1)dyr=matrix[i][j]+dp[i+1][j+1];

//                 dp[i][j]=Math.min(d,Math.min(dyl,dyr));
//             }
//          } 
//          int min=Integer.MAX_VALUE;
//          for(int j=0;j<n;j++){
//             min=Math.min(min,dp[0][j]);
//          }
//         return min;
//     }
// }

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];

        // Initialize the bottom row of dp with the corresponding values of matrix
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }

        // Fill the dp array from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int d = matrix[i][j] + dp[i + 1][j]; // down
                int dyl = j > 0 ? matrix[i][j] + dp[i + 1][j - 1] : Integer.MAX_VALUE; // down-left
                int dyr = j < n - 1 ? matrix[i][j] + dp[i + 1][j + 1] : Integer.MAX_VALUE; // down-right

                dp[i][j] = Math.min(d, Math.min(dyl, dyr));
            }
        }

        // Find the minimum value in the first row of dp
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[0][j]);
        }

        return min;
    }
}
