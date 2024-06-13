/*
Pseudo-code:
CoinChange(coins, amount):
Declare array dp of size amount + 1
dp[0] = 0
for i = 1 to amount
    dp[i] = infinity
    for each coin in coins
        if i >= coin
            dp[i] = min(dp[i], dp[i - coin] + 1)
return dp[amount] if dp[amount] != infinity else -1

*/


//Code:
package DP;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        // input
        int[] coins = {1, 2, 5};
        int amount = 11;

        // output
        System.out.println("Fewest number of coins that you need: " + coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

