    // 1 4 6
    //   2 5
    //     3
package mcm;
import java.util.Scanner;


class print{
    int arr[][];
    int size;
    print(int size){
        arr=new int[size][size];
        this.size=size;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                arr[i][j]=0;
            }
        }
    }

    void mcm(){
        int l=0;
        for(int k=0;k<size;k++){
            for(int i=0;i<size-k;i++){
                int j=i+k;
                arr[i][j]=++l;
            }
        }
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("\n");
        }



    }
}
public class basic {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int size;
        System.out.println("matrix size: ");
        size=sc.nextInt();
        print obj=new print(size);
        obj.mcm();
        sc.close();


    }
}
