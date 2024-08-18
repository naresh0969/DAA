//check whether given number is sum of the subsets of an array.(true/false).
//dynamic programming



import java.util.Scanner;
class Subset{
    int arr[];
    boolean res[][];
    Subset(int arr[], int key){
        int size=arr.length+1;
        this.arr=new int[size];
        this.arr=arr;

        res=new boolean[size][key+1];
        for(int i=0;i<=size;i++){
            for(int j=0;j<=key;j++){
                res[i][j]=false;
            }
        }
    }
    boolean cc(int n,int w){
        if(res[n][w]!=false){
            return true;
        }
        if(n==0){
            return false ;
        }
        if(arr[n-1]<=w){
            return (cc(n-1,w-arr[n-1])|| cc(n-1,w));
        }
        else{
            return cc(n-1,w);
        }
    }

}

public class q1d {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[];
        int size;
        int key;
        System.out.println("size?");
        size=sc.nextInt();
        arr=new int[size];
        System.out.println("Enter elements");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("give value :");
        key=sc.nextInt();
        Subset obj=new Subset(arr,key);
        System.out.println(obj.cc(size,key));

        sc.close();

    }
}


