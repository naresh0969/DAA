import java.util.*;

class sack{
    int val[];
    int wt[];
    int a[];
    sack(int n,Scanner s){
        val=new int[n];
        wt=new int[n];
        a=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("enter "+i +" val and"+i+" wt:");
            val[i]=s.nextInt();
            wt[i]=s.nextInt();
            a[i]=val[i]/wt[i];
        }
    }
        void increasing(int n){
            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    if(a[i]<a[j]){
                        int temp=a[i];
                        a[i]=a[j];
                        a[j]=temp;
                        int temp1=val[i];
                        val[i]=val[j];
                        val[j]=temp1;
                        int temp2=wt[i];
                        wt[i]=wt[j];
                        wt[j]=temp2;
                    }
                }
            }
        }
        int knap(int n,int w){
            int v=0;
            for(int i=0;i<n;i++){
                if(wt[i]<=w){
                    v=v+val[i];
                    w=w-wt[i];
                }
                else{
                    
                    int p=(w * val[i]) / wt[i];
                    System.out.println(p);
                    v=p+v;
                    break;
                }
            }
            return v;
        }
}


class fra_knap_rec {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int w=s.nextInt();
        sack sc=new sack(n,s);
        sc.increasing(n);
        System.out.println(sc.knap(n,w));
    }
}
