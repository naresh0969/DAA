package practice;
class Knapsack{
    int wts[];
    int val[];
    int bw;
    Knapsack(int wts[],int val[],int bw){
        this.wts=wts;
        this.val=val;
        this.bw=bw;
    }
    int ks(int n,int bw){
        if(n==0 || bw==0) return 0;
        if(wts[n-1]<=bw){
            return Math.max(ks(n-1,bw),val[n-1]+ks(n-1,bw-wts[n-1]));
        }
        else{
            return ks(n-1,bw);
        }
    }
}
public class KsR {
    public static void main(String args[]){
        int wts[]={100,70,50,120};
        int val[]={30,80,50,100};
        int bw=150;
        Knapsack obj = new Knapsack(wts,val,bw);
        System.out.println(obj.ks(4,bw));



    }
}
