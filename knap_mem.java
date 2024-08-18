 
 
 import java.util.*;

 class suck{
     int wt[];
     int val[];
     int adj[][];
     suck(int n,int w){
         Scanner s=new Scanner(System.in);
         wt=new int[n];
         val=new int[n];
         adj=new int[n+1][w+1];
         for(int i=0;i<n;i++){
             System.out.print("enter wt value:");
             wt[i]=s.nextInt();
             System.out.print("enter bag val:");
             val[i]=s.nextInt();
         }

         for(int i=0;i<=n;i++){
            for(int j=0;j<=w;j++){
                adj[i][j]=-1;
            }
         }
     }
     int sack(int n,int w){
        if(adj[n][w]!=-1){
            return adj[n][w];
        }
         if(n==0||w==0){
             return adj[n][w]=0;
         }
         if(wt[n-1]<=w){
             return adj[n][w]= Math.max(val[n-1]+sack(n-1,w-wt[n-1]),sack(n-1,w));
         }
         else{
             return adj[n][w]= sack(n-1,w);
         }
     }
 }
 
 class knap_mem {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter n value:");
        int n=sc.nextInt();
        System.out.print("enter bag value:");
        int w=sc.nextInt();
        suck k= new suck(n,w);
        System.out.println("Total weight a bag can carry is :"+k.sack(n,w));
    }
}
