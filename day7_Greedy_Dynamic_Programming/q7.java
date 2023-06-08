

/*

7. Write a program to find out the minimum no of coins to make change of given amount
For example, for N = 10 and S = {1,5,6,9}, there are two solutions: {5,5},{1,9} So output should
be 2. [Infinite Supply of coins]

*/


import java.util.Arrays;

public class q7 {
    // Function to find the minimum number of coins required
    static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 5, 6, 9 };
        int amount = 10;

        int minCoins = coinChange(coins, amount);
        System.out.println("Minimum number of coins required: " + minCoins);
    }
}



/*
OUTPUT -


Minimum number of coins required: 2


*/

