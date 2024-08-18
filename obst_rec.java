import java.util.*;
 
class obst{
    int a[];
    obst(int n){
        a=new int[n+1];
        Scanner s=new Scanner(System.in);
        for(int i=1;i<=n;i++){
            a[i]=s.nextInt();
        }
    }
    int find(int i,int j){
        if(i>j){
            return 0;
        }
        if(i==j){
            return a[i];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int val=find(i,k-1)+find(k+1,j)+sum(i,j); 
            if(val<min){
                min=val;
            }
        }
        return min;
    }
    int sum(int i,int j){
        int s=0;
        for(int k=i;k<=j;k++){
            s+=a[k];
        }
        return s;
    }
}

class obst_rec {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        obst o=new obst(n);
        System.out.println(o.find(1,n));
    }
}
