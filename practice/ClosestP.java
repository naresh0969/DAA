package practice;
import java.util.*;

class pairs{
    double points[][];
    int size;
    pairs(double arr[][],int size){
        points = arr;
        this.size=size;
        if(size<2){
            System.out.println("very less points");
            return;
        }
    }
    double d= Double.POSITIVE_INFINITY;
    public double distance(double arr1[], double arr2[]){
        return Math.sqrt(Math.pow((arr1[0]-arr2[0]), 2)+Math.pow((arr1[1]-arr2[1]),2));
    }

    void mindis(){
        double minimumd=Double.POSITIVE_INFINITY;
        int index1=0;
        int index2=0;
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                double d = distance(points[i],points[j]);
                if(d<minimumd){
                    minimumd=d;
                    index1=i;index2=j;
                }

            }

        }
        System.out.println("minimum distance is "+minimumd+" between "+index1+1+" and "+index2+1+"points");
        System.out.println("("+points[index1][0]+" ,"+points[index1][1]+") , ("+points[index2][0]+" ,"+points[index2][1]+")");

    }


}

public class ClosestP {
    public static void main(String args[]){
        int size;
        Scanner sc=new Scanner(System.in);
        System.out.println("how many points?");
        size=sc.nextInt();
        double arr[][];
        arr=new double[size][2];
        for(int i=0;i<size;i++){
            System.out.println("enter x and y coordinate of point "+(i+1));
            arr[i][0]=sc.nextDouble();
            arr[i][1]=sc.nextDouble();

        }
        pairs p=new pairs(arr,size);
        p.mindis();

        sc.close();
    }
}
