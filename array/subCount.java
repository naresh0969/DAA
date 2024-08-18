//this is tabulation code to find no. of ways where it's sum equal to given value.
class Subset{
    int count(int arr[],int val){
        int size=arr.length;
        int res[][];
        res=new int[size+1][val+1];
        for(int i=0;i<=size;i++){
            res[i][0]=1;
        }
        for(int j=1;j<=val;j++){
            res[0][j]=0;
        }
        for(int i=1;i<=size;i++){
            for(int j=1;j<=val;j++){
                if(arr[i-1]<=j){
                    res[i][j]=res[i-1][j]+res[i-1][j-arr[i-1]];
                }
                else{
                    res[i][j]=res[i-1][j];
                }
            }
        }
        return res[size][val];
        
    }
}
public class subCount {
    public static void main(String args[]){
        int arr[]={2,1,3};
        int val=3;
        Subset obj=new Subset();
        System.out.println(obj.count(arr,val));

    }
}
