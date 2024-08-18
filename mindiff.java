class Diff{
    int arr[];
    int half,sum=0;
    boolean dp[][];
    Diff(int arr[]){
        this.arr = arr;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        half = sum/2;
        dp=new boolean [arr.length+1][half+1];
        for(int i=0;i<=arr.length;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=half;i++){
            dp[0][i]=true;
        }
    }
    int find(){
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=half;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        for(int j=arr.length;j<=half;j++){
            if(dp[arr.length][j]==true){
                int val=sum-2*j;
                if(val<min) min=val;

            }

        }
        return min;
    }
    
    
    
}
public class mindiff {
    public static void main(String args[]){
        int arr[]={1,2,3,4,5};
        Diff obj=new Diff(arr);
        System.out.println(obj.find());
        
    }
}
