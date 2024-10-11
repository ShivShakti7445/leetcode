// class Solution {
//     public int maxProfit(int[] prices) {
//         int ans=0;
//         for(int i=1;i<prices.length;i++){
//             if(prices[i]>prices[i-1]) {int cost=prices[i]-prices[i-1]; ans+=cost;}
//         }
//         return ans;
//     }
// }

// by tabution methood

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n+1][2];

        dp[n][0]=dp[n][1]=0;

        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                if(buy==1){
                   profit=Math.max(-prices[ind]+dp[ind+1][0],dp[ind+1][1]);
                }
                else{
                   profit=Math.max(prices[ind]+dp[ind+1][1],dp[ind+1][0]);
                }
                dp[ind][buy]=profit;
            }
        }
        return dp[0][1];
    }
}