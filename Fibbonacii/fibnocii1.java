package Fibbonacii;
//Fibbonocii series using recurssion
import java.util.Scanner;
class Fib{
    int fibbo(int n){
        if(n==0||n==1) return 1;
        else
            return(fibbo(n-1)+fibbo(n-2));

    }

}
class fibnocii1{
    public static void main(String args[]){
        int size;
        Scanner scan=new Scanner(System.in);
        size=scan.nextInt();
        Fib f=new Fib();
        System.out.println(f.fibbo(size));
        scan.close();

    }
}