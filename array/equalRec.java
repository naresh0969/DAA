//recursion code to check whether given array can divide into 2 equal parts.
class isEqual{
    boolean check(int arr[],int half,int size){
        if(half==0){
            return true;
        }
        if(size==0){
            return false;
        }
        else if(arr[size-1]<=half){
            return check(arr,half,size-1)||check(arr,half-arr[size-1],size-1);
        }
        else{
            return check(arr,half,size-1);
        }

    }
}
public class equalRec {
    public static void main(String args[]){
        int arr[]={1,3,2};
        int size=arr.length;
        int sum=0;
        int half=0;
        for(int i=0;i<size;i++){
            sum+=arr[i];
        }
        half=sum/2;
        if(sum%2!=0){
            System.out.println("false");
        }
        else{
            isEqual obj=new isEqual();
            System.out.println( obj.check(arr,half,size));
        }



    }
}
