package Fibbonacii;
//Fibbonocii series using Tabulation
import java.util.Scanner;
class Fib{
    int size;
    int arr[];
    Fib(int size){
        this.size=size;
        arr=new int[size+1];
    }
    void series(){
        for(int i=0;i<=size;i++){
            if(i==0||i==1){
                arr[i]=1;
            }
            else{
                arr[i]=arr[i-1]+arr[i-2];
            }
        }
        System.out.print("Series : ");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

public class Fibbonocii3 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        Fib f=new Fib(size);
        f.series();
        sc.close();

    }
}
