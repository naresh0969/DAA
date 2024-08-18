
//check whether given number is sum of the subsets of an array.(true/false).
//recursion



import java.util.Scanner;


public class q1r {
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
        Subset obj=new Subset(arr);
        System.out.println(obj.cc(size,key));

        sc.close();

    }
}


class Subset{
    int arr[];
    Subset(int arr[]){
        int size=arr.length;
        this.arr=new int[size];
        this.arr=arr;
    }
    boolean cc(int n,int w){
        if(w==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(arr[n-1]<=w){
            return (cc(n-1,w-arr[n-1])|| cc(n-1,w));
        }
        else{
            return cc(n-1,w);
        }
    }

}
