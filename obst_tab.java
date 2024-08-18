import java.util.*;

class tab{
    int a[];
    int adj[][];
    tab(int n){
        a=new int[n+1];
        Scanner sc=new Scanner(System.in);
        adj=new int[n+2][n+2];
        for(int i=1;i<=n;i++){
            a[i]=sc.nextInt();
        }
    }
    int table(int n){
        for(int l=0;l<n;l++){
            for(int k=1;k<=n-l;k++){
                int j=k+l;
                if(k==j){
                    adj[k][j]=a[k];
                    continue;
                }
                if (k > j) {
                    adj[k][j]=0; 
                    continue;
                }
                int min=Integer.MAX_VALUE;
                for(int i=k;i<=j;i++){
                    int val=adj[k][i-1]+adj[i+1][j]+sum(k,j);
                    if(val<min){
                        min=val;
                    }
                }
                adj[k][j]=min;
            }
        }
        return adj[1][n];
        
    }
    int sum(int i,int j){
        int s=0;
        for(int k=i;k<=j;k++){
            s+=a[k];
        }
        return s;
    }
}

class obst_tab {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        tab t=new tab(n);
        System.out.println(t.table(n));
    }
}
