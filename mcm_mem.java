
import java.util.*;

class rec{
    int a[];
    int dp[][];
    int val=0;
    rec(int n){
        a=new int[n+1];
        dp=new int[n+1][n+1];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<=n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
    }
    int matrix(int i,int j){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i==j){
            return dp[i][j]=0;
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            val=matrix(i,k)+matrix(k+1, j)+a[i-1]*a[j]*a[k];
            if(val<min){
                min=val;
            }
        }
        return dp[i][j]=min;
    }
}


class mcm_mem {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        rec r=new rec(n);
       System.out.println(r.matrix(1,n));
    }
}
