

class coin {

    static int ks(int i, int target, int arr[]) {
        if (target == 0) {
            return 0; // No coins are needed if target is 0
        }
        if (i < 0) {
            return Integer.MAX_VALUE; // No coins available and target not met
        }
        
        // Don't include the coin
        int np = ks(i - 1, target, arr);
        
        // Include the coin (if the coin value is less than or equal to the target)
        int p = Integer.MAX_VALUE;
        if (arr[i] <= target) {
            int subRes = ks(i, target - arr[i], arr); // Recurse with the same index i
            if (subRes != Integer.MAX_VALUE) {
                p = 1 + subRes; // Include the current coin
            }
        }
        
        return Integer.min(p, np);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 5, 10};
        int result = ks(arr.length - 1, 11, arr);
        if (result == Integer.MAX_VALUE) {
            System.out.println("No solution possible");
        } else {
            System.out.println("Minimum coins needed: " + result);
        }
    }
}
