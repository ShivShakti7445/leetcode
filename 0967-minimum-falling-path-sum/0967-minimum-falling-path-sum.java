class Solution {
    public int minFallingPathSum(int[][] matrix) {
         int n=matrix.length;
         int dp[][]=new int[n][n];
         for(int j=0;j<n;j++){
            dp[n-1][j]=matrix[n-1][j];
         }
         for(int i=n-2;i>=0;i--){
            int dyl=Integer.MAX_VALUE;
            int dyr=Integer.MAX_VALUE;
            for(int j=n-1;j>=0;j--){
                 int d=matrix[i][j]+dp[i+1][j];
                 if(j>0)dyl=matrix[i][j]+dp[i+1][j-1];
                 if(j<n-1)dyr=matrix[i][j]+dp[i+1][j+1];

                dp[i][j]=Math.min(d,Math.min(dyl,dyr));
            }
         } 
         int min=Integer.MAX_VALUE;
         for(int j=0;j<n;j++){
            min=Math.min(min,dp[0][j]);
         }
        return min;
    }
}