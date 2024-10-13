class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1; 
            }
        }
        return ans(0,-1,nums,n,dp);

    }
    static int ans(int ind,int pind,int[] nums,int n,int dp[][]){
        if(ind==n)return 0;
        if(dp[ind][pind+1]!=-1)return (dp[ind][pind+1]);
        int nottake=0+ans(ind+1,pind,nums,n,dp);
        int take=0;
        if(pind==-1||nums[ind]>nums[pind]){
            take=1+ans(ind+1,ind,nums,n,dp);
        }
        return dp[ind][pind+1]=Math.max(take,nottake);
    }
}