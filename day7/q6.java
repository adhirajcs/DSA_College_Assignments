

/*

6. Write a program to find out the total number of ways to make change of given amount.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1}, {1,1,2}, {2,2}, {1,3}.
So output should be 4. [Infinite Supply of coins]

*/


public class q6 {
    // Function to find the total number of ways to make change
    static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // Base case

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3 };
        int amount = 4;

        int totalWays = coinChange(coins, amount);
        System.out.println("Total number of ways to make change: " + totalWays);
    }
}




/*
OUTPUT -


Total number of ways to make change: 4


*/

