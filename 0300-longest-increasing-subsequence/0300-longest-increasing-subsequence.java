// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n=nums.length;
//         int dp[][]=new int[n+1][n+1];
//         for (int i = 0; i <= n; i++) {
//             dp[n][i] = 0;
//         }
//         for(int ind=n-1;ind>=0;ind--){
//             for(int pind=ind-1;pind>=-1;pind--){
//                 int nottake=0+dp[ind+1][pind+1];
//                 int take=0;
//                 if(pind==-1||nums[ind]>nums[pind]){
//                     take=1+dp[ind+1][ind+1];
//                 }
//                 dp[ind][pind+1]=Math.max(take,nottake);
//             }
//         }
//         return dp[0][-1+1];
//     }
// }

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        for (int i = 0; i <n; i++) {
            dp[i] = 1;
        }
        int maxi=1;
        for(int ind=0;ind<n;ind++){
            for(int pind=0;pind<ind;pind++){
                if(nums[ind]>nums[pind]){
                    dp[ind]=Math.max(dp[ind],1+dp[pind]);
                    maxi=Math.max(maxi,dp[ind]);
                }
            }
        }
        return maxi;
    }
}