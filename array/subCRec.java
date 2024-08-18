class Subset{
    int count(int arr[],int val,int size){
        if(val==0){
            return 1;
        }
        if(size==0){
            return 0;
        }
        if(arr[size-1]<=val){
            return count(arr,val,size-1)+count(arr,val-arr[size-1],size-1);
        }
        else{
            return count(arr,val,size-1);
        }
        
    }
}
public class subCRec {
    public static void main(String args[]){
        int arr[]={2,1,3};
        int val=3;
        int size=arr.length;
        Subset obj=new Subset();
        System.out.println(obj.count(arr,val,size));

    }
    
}
