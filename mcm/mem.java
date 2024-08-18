package mcm;
class mcm{
    int arr[];
    mcm(int arr[]){
        this.arr=arr;
    }
    int find(int i,int j){
        if(i==j) return 0;
        else{
            int min=Integer.MAX_VALUE;
            for(int k=i;k<j;k++){
                int temp=find(i,k)+find(k+1,j)+arr[i-1]*arr[k]*arr[j];
                if(temp<min) min=temp;
            }
            return min;
        }
    }
}
public class mem {
    public static void main(String args[]){
        int arr[]={2,3,2,4};
        mcm obj=new mcm(arr);
        System.out.println(obj.find(1,3));

        
    }
}
