

class Solution {
    public int change(int amount, int[] coins) {
        return coinChange(coins, amount);
    }

    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount + 1];

        // Base case: when using only the first type of coin
        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0) {
                dp[0][amt] = 1;  // There's exactly one way to make amount `amt` with coins[0].
            } else {
                dp[0][amt] = 0;  // No way to make this amount with only coins[0].
            }
        }

        // Base case: when amount is 0, there's one way to make amount 0 (using no coins)
        for (int ind = 0; ind < coins.length; ind++) {
            dp[ind][0] = 1;
        }

        // Fill the dp array for other coins
        for (int ind = 1; ind < coins.length; ind++) {
            for (int amt = 0; amt <= amount; amt++) {
                int nottake = dp[ind - 1][amt];  // not taking the current coin
                
                int take = 0;  // taking the current coin
                if (coins[ind] <= amt) {
                    take = dp[ind][amt - coins[ind]];
                }
                dp[ind][amt] = take + nottake;
            }
        }

        return dp[coins.length - 1][amount];
    }
}

