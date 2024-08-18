package practice;
import java.util.Scanner;
public class Nqueen {
    static int res[];
    static int n;
    res=new int[n];
    static void find(int n ,int r){
        if(r>n) print();
       
        for(int c=1;c<=n;c++){
            if(isSafe(r,c)){
                res[r]=c;
                find(n,r+1);

            }

        }
    }
    static void print(){
        for()

    }
    static boolean isSafe(int r, int c){
        for(int j=1;j<=r;j++){
            if(res[j]==c) return false;
            if(Math.abs(r-j)==Math.abs(c-res[j])) return false;
        }
        return true;

    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter No. of queens :");
        n=sc.nextInt();
        int res[]=new int[n];
        find(n,1);
    }
    
}
