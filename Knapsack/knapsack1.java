import java.util.Scanner;
class KS{
    int wt[];
    int val[];
    KS(int wt[],int val[]){
        this.wt=wt;
        this.val=val;
    }

    int ks(int n,int w){
        if(n==0||w==0) return 0;
        if(wt[n-1]<=w){
            int val1=val[n-1]+ks(n-1,w-wt[n-1]);
            int val2=ks(n-1,w);
            return Math.max(val1,val2);
        }
        else{
            return ks(n-1,w);
        }
    
    }
}
public class knapsack1 {
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

        KS obj=new KS(wt,val);
        System.out.println(obj.ks(nw,bw));
        sc.close();
    }
}
