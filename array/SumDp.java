// The code checks if there is a subset of numbers
// in a given array that adds up to a specific sum.
// It returns true if such a subset exists, and false otherwise.

class Check{
    int arr[],sum,size;
    boolean [][] res;
    
    Check(int arr[],int sum){
        this.arr=arr;
        this.sum=sum;
        size=arr.length;

    }

    boolean present(){
        res=new boolean[size+1][sum+1];
        for(int i=0;i<=size;i++){
            res[i][0]=true;
        }
        for(int j=1;j<=sum;j++){ 
            res[0][j]=false;
        }
        for(int i=1;i<=size;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    res[i][j]=res[i-1][j-arr[i-1]]||res[i-1][j];
                }
                else{
                    res[i][j]=res[i-1][j];
                }
            }
    
        }
        return (res[size][sum]);

    }


}
public class SumDp {
    public static void main(String args[]){
        int arr[]={2,1,3};
        int sum=3;
        Check obj=new Check(arr,sum);
        System.out.println(obj.present());
    }
    
}
