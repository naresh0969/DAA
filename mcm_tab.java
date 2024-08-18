import java.util.*;

class table{
    int a[];
    int adj[][];
    int val;
    table(int n){
        Scanner s=new Scanner(System.in);
        a=new int[n];
        adj=new int[n][n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }

    }
    int fill(int n){
        for(int l=0;l<n;l++){
            for(int i=1;i<n-l;i++){
                int j=i+l;
                if(i==j){
                    adj[i][j]=0;
                    continue;
                }
                int min=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    val=adj[i][k]+adj[k+1][j]+a[i-1]*a[k]*a[j];
                    if(val<min){
                        min=val;
                    }
                    adj[i][j]=min;
                }
            }
        }
        return adj[1][n-1];
    }
}

class mcm_tab {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        table t=new table(n);
        System.out.println(t.fill(n));
    }
}
