

/*

8. Given a set of non-negative integers, and a value sum, Write a program to determine if there is a
subset of the given set with sum equal to given sum. Input: set [] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True [ There is a subset (4, 5) with sum 9]


*/



public class q8 {
    // Function to check if there is a subset with the given sum
    static boolean hasSubsetSum(int[] set, int sum) {
        int n = set.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (set[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - set[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] set = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;

        boolean hasSubset = hasSubsetSum(set, sum);
        System.out.println("Subset with sum " + sum + " exists: " + hasSubset);
    }
}




/*
OUTPUT -


Subset with sum 9 exists: true


*/

