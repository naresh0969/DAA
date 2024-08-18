//tabulation code to check whether given array can divide into 2 equal parts.
class Partation{
    boolean check(int arr[]){
        int sum=0;
        int size=arr.length;
        boolean res[][];
        for(int i=0;i<size;i++){
            sum+=arr[i];
        }
        if(sum%2!=0){
            return false;

        }
        else{
            int half=sum/2;
            res=new boolean[size+1][half+1];
            for(int i=0;i<=size;i++){
                res[i][0]=true;
            }
            for(int j=1;j<=half;j++){
                res[0][j]=false;
            }
            for(int i=1;i<=size;i++){
                for(int j=1;j<=half;j++){
                    if(arr[i-1]<=j){
                        res[i][j]=res[i-1][j-arr[i-1]]||res[i-1][j];
                    }
                    else{
                        res[i][j]=res[i-1][j];
                    }
                }
            }
            return res[size][half];
        }

    }
}
public class EqualTb {
    public static void main(String args[]){
        int arr[]={1,5,11,5};
        Partation obj=new Partation();
        boolean result=obj.check(arr);
        System.out.println(result);

    }
}
