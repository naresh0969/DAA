import java.util.Scanner;
class KS2{
    int wt[];
    int val[];
    int res[][];
    KS2(int wt[],int val[],int bw){
        this.wt=wt;
        this.val=val;
        int n=wt.length;
        res=new int[n][bw];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=bw;j++){
                res[i][j]=-1;
            }
        }
    }


    int ks(int n,int w){
        if(res[n][w]!=-1){
            return res[n][w];
        }
        if(n==0||w==0) return res[n][w]=0;
        if(wt[n-1]<=w){
            int val1=val[n-1]+ks(n-1,w-wt[n-1]);
            int val2=ks(n-1,w);
           return res[n][w]=Math.max(val1,val2);
        }
        else{
            return res[n][w]=ks(n-1,w);
        }
    
    }
}
public class Knapsack2 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int bw,nw;
        int wt[];
        int val[];
        System.out.println("How many weights ? ");
        nw=sc.nextInt();
        wt=new int[nw];
        val=new int[nw];
        System.out.println("Enter weights ");
        for(int i=0;i<nw;i++){
            wt[i]=sc.nextInt();
        }
        System.out.println("Enter values ");
        for(int i=0;i<nw;i++){
            val[i]=sc.nextInt();
        }
        System.out.println("Enter Bag weight ");
        bw=sc.nextInt();

        KS2 obj=new KS2(wt,val,bw);
        System.out.println(obj.ks(nw,bw));
        sc.close();
    }
}
