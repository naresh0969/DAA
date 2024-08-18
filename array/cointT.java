public class cointT {
    static int ks(int arr[],int target){
        int dp[][];
        dp=new int[arr.length+1][target+1];
        for(int i=0;i<=arr.length;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<=target;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=target;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }

        }
        return dp[arr.length][target];



    }

    public static void main(String args[]){
        int arr[]={1,2,3,5,10};
        int target=5;
        System.out.println(ks(arr,target));

    }
}
// public class CoinChange {
//     static int coinChange(int[] coins, int amount) {
//         int[] dp = new int[amount + 1];
//         dp[0] = 1; // There is one way to make zero amount: by using no coins

//         for (int coin : coins) {
//             for (int j = coin; j <= amount; j++) {
//                 dp[j] += dp[j - coin];
//             }
//         }

//         return dp[amount];
//     }

//     public static void main(String[] args) {
//         int arr[] = {1, 2, 5, 10};
//         int target = 11;
//         System.out.println(coinChange(arr, target));
//     }
// }
