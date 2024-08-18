package practice;
class Knapsack{
    int wts[];
    int val[],res[][];
    int bw;
    Knapsack(int wts[],int val[],int bw){
        this.wts=wts;
        this.val=val;
        this.bw=bw;

        res=new int[val.length+1][bw+1];
        for(int i=0;i<=val.length;i++){
            for(int j=0;j<=bw;j++){
                res[i][j]=-1;
            }
        }
    }
    int ks(int n,int bw){
        if(res[n][bw]!=-1){
            return res[n][bw];
        }
        if(n==0 || bw==0) return res[n][bw]=0;
        if(wts[n-1]<=bw){
            return res[n][bw]=Math.max(ks(n-1,bw),val[n-1]+ks(n-1,bw-wts[n-1]));
        }
        else{
            return res[n][bw]=ks(n-1,bw);
        }
    }
}
public class KsM {
    public static void main(String args[]){
        int wts[]={10,7,5,12};
        int val[]={30,80,50,10};
        int bw=16;
        Knapsack obj = new Knapsack(wts,val,bw);
        System.out.println(obj.ks(4,bw));



    }
}
