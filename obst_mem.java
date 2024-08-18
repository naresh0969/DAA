import java.util.Scanner;

class obst_m{
    int a[];
    int adj[][];
    obst_m(int n){
        a=new int[n+1];
        adj=new int[n+2][n+2];
        Scanner s=new Scanner(System.in);
        for(int i=1;i<=n;i++){
            a[i]=s.nextInt();
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                adj[i][j]=-1;
            }
        }
    }
    int find(int i,int j){
        if(adj[i][j]!=-1){
            return adj[i][j];
        }
        if(i>j){
            return adj[i][j]=0;
        }
        if(i==j){
            return adj[i][j]=a[i];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int val=find(i,k-1)+find(k+1,j)+sum(i,j);
            if(val<min){
                min=val;
            }
        }
        return adj[i][j]=min;
    }
    int sum(int i,int j){
        int s=0;
        for(int k=i;k<=j;k++){
            s+=a[k];
        }
        return s;
    }
}

class obst_mem {
        public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        obst_m o=new obst_m(n);
        System.out.println(o.find(1,n));
    }
}
