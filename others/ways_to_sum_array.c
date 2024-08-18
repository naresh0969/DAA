//no. of ways to get sum of given number
import java.util.*;
class subset{
    int a[];
    int b[][];
    subset(int n,int w){
        Scanner s=new Scanner(System.in);
        a=new int[n];
        b=new int[n+1][w+1];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        for(int i=0;i<n+1;i++){
            for (int j=0;j<w+1;j++){
                b[i][j]=-1;
            }
        }
    }
    int sum(int n,int w){
        if(b[n][w]!=-1){
            return b[n][w];
        }
        if(w==0){
            return b[n][w]=1;
        }
        if(n==0){
            return b[n][w]=0;
        }
        else if(a[n-1]<=w){
            return b[n][w]=(sum(n-1,w-a[n-1])+sum(n-1,w));
        }
        else{
            return b[n][w]=sum(n-1,w);
        }
    }
}



public class sub_mem_ways {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int w=sc.nextInt();
        subset s=new subset(n,w);
        System.out.println(s.sum(n,w));
    }
}
