package mcm;

class Mcm{
    int arr[];
    Mcm(int arr[]){
        this.arr=arr;
    }
    int mcm(int i,int j){
        if(i==j)
            return 0;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int val=mcm(i,k)+mcm(k+1,j)+arr[i-1]*arr[k]*arr[j];
            if(val<min) min=val;
        }
        return min;
    }
}
public class rec {
    public static void main(String args[]){
        int arr[]={2,3,2,4};
        Mcm obj=new Mcm(arr); 
        System.out.println( obj.mcm(1,3));


    }
}
