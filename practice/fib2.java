//fibonacci using memorization
package practice;
import java.util.*;
class series{
    int res[];
    int range=0;
    series(int size){
        range=size;
        res=new int[size];
        for(int i=0;i<size;i++){
            res[i]=-1;
        }

    }
    int fibonacci(int range){
        if(res[range]!=-1){
            return res[range];
        }
        else if(range==0||range==1){
            return res[range]=range;
        }
        else{
            return res[range]=fibonacci(range-1)+fibonacci(range-2);
        }

        
    }
    void print(){
        for(int i=0;i<range;i++){
            System.out.print(res[i]+",");
        }
    }

}
public class fib2 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter range");
        int n=sc.nextInt();
        series obj=new series(n);
        obj.fibonacci(n-1);
        obj.print();
        sc.close();

    }
}
