public class minDif {
    public static void main(String[] args) {
        int[] arr = {45, 34, 4, 12, 5, 2}; // Example input array

        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Initialize the DP array to store subset sum information
        boolean[][] dp = new boolean[arr.length + 1][totalSum + 1];

        // Base case: An empty subset can always achieve a sum of 0
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }

        // Fill the DP array using the subset sum approach
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= totalSum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the minimum difference between two subsets
        int minDiff = Integer.MAX_VALUE;
        for (int j = totalSum / 2; j >= 0; j--) {
            if (dp[arr.length][j]) {
                minDiff = totalSum - 2 * j;
                break;
            }
        }

        System.out.println("Minimum subset sum difference: " + minDiff);
    }
}
