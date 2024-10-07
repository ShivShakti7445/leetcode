  

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount + 1];

        // base case: when only using the first type of coin
        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0) {
                dp[0][amt] = amt / coins[0];
            } else {
                dp[0][amt] = Integer.MAX_VALUE;
            }
        }

        // fill the dp array for other coins
        for (int ind = 1; ind < coins.length; ind++) {
            for (int amt = 0; amt <= amount; amt++) {
                int nottake = dp[ind - 1][amt]; // not taking the current coin
                int take = Integer.MAX_VALUE;  // taking the current coin
                if (coins[ind] <= amt && dp[ind][amt - coins[ind]] != Integer.MAX_VALUE) {
                    take = 1 + dp[ind][amt - coins[ind]];
                }
                dp[ind][amt] = Math.min(take, nottake);
            }
        }

        int ans = dp[coins.length - 1][amount];
        if (ans == Integer.MAX_VALUE) return -1;  // no valid solution
        return ans;
    }
}
