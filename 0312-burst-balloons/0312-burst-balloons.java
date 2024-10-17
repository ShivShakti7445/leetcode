class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int newcuts[]=new int[n+2];
        System.arraycopy(nums,0,newcuts,1,n);
        newcuts[0]=1;
        newcuts[n+1]=1;
        // Arrays.sort(newcuts);
        int dp[][]=new int[n+2][n+2];
        for(int row[]:dp){
            Arrays.fill(row,0);
        }
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j) continue;
                int mini = Integer.MIN_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int ans=newcuts[i-1]*newcuts[j+1]*newcuts[ind]+dp[i][ind-1]+dp[ind+1][j];
                    mini=Math.max(mini,ans);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][n];
    }
}