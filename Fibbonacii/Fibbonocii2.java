package Fibbonacii;
//Fibbonocii series using memorization(DP)
import java.util.Scanner;

class Fib{
    int n;
    int arr[];
    public Fib(int size){
        n=size;
        arr=new int [n+1];
        for(int i=0;i<=n;i++){
            arr[i]=-1;
        }
    }
    int fibbo(int n){
        if(arr[n]!=-1){
            return arr[n];
        }
        if(n==0||n==1) {
            return arr[n]=1;
        }
        else
            return arr[n]=fibbo(n-1)+fibbo(n-2);

    }
    void display(){
        for(int i=0;i<=n;i++){
            System.out.print(arr[i]+" ");

        }
    }

}
class Fibbonocii2{
    public static void main(String args[]){
        int size;
        Scanner scan=new Scanner(System.in);
        size=scan.nextInt();
        Fib f=new Fib(size);
        System.out.println(f.fibbo(size));

        System.out.print("Array ");
        f.display();

        scan.close();

    }
}