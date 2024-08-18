import java.util.Scanner;
class Dp{
    int wt[];
    int val[];
    int res[][];
    Dp(int wt[],int val[],int bw){
        int n=wt.length;
        wt=new int[n];
        val=new int[n];
        this.wt=wt;
        this.val=val;
        
        res=new int[n+1][bw+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=bw;j++){
                res[i][j]=-1;
            }
        }
    }
    int ks(int n,int bw){
        if(res[n][bw]!=-1){
            return res[n][bw];
        }
        if(wt[n-1]<=bw){
            int val1=val[n-1]+ks(n-1,bw-wt[n-1]);
            int val2=ks(n-1,bw);
            return res[n][bw]= Math.max(val1,val2);
        }
        else{
            return res[n][bw]=ks(n-1,bw);
        }

    }
    
}

public class Ks2 {
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

        Dp obj=new Dp(wt,val,bw);
        System.out.println(obj.ks(nw,bw));
        sc.close();
    }
}
