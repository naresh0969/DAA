package practice;
import java.util.*;
class pair{
    double points[][];
    int size;
    pair(double arr[][],int size){
        this.points=arr;
        this.size=size;
    }
    double[] distance(){
        double res=Double.MAX_VALUE;
        int p1,p2;
        double arr[];
        arr=new double[3];
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                double dis=Math.sqrt(Math.pow((points[j][0]-points[i][0]),2)+Math.pow((points[j][1]-points[i][1]),2));
                if(dis<res){
                    res=dis;
                    arr[0]=i;
                    arr[1]=j;
                }
            }
        }
        arr[2]=res;
        return arr;
    }
}
public class cp {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        double points[][];
        int size;
        double res[];
        System.out.println("Enter No. of points: ");
        size=sc.nextInt();
        points=new double[size][size];
        for(int i=0;i<size;i++){
            System.out.println("Enter point "+(i+1));
            points[i][0]=sc.nextInt();
            points[i][1]=sc.nextInt();
        }
        pair obj=new pair(points,size);
        res=obj.distance();
        System.out.println("Distance="+res[2]);
        System.out.println("The Closest pair is point ("+(int)points[(int)res[0]][0]+","+(int)points[(int)res[0]][1]+"),("+(int)points[(int)res[1]][0]+","+(int)points[(int)res[1]][1]+")");
        sc.close();


    }
}
