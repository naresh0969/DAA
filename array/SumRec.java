class Check{
    boolean result=false;
    boolean find(int arr[],int size, int sum ){
        if(sum==0){
            return true;
        } 
        if(size==0){
            return false;
        }
        else if(arr[size-1]<=sum){
            return find(arr,size-1,sum-arr[size-1])||find(arr,size-1,sum);
        }
        else{
            return find(arr,size-1,sum);
        }
    }
}
public class SumRec {
    public static void main(String args[]){
        int arr[]={2,1,3};
        int sum=3;
        int size=arr.length;
        boolean result;
        Check obj=new Check();
        result=obj.find(arr,size,sum);
        System.out.println(result);

    }
}
