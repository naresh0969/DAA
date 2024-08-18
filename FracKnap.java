package practice;
class Knap{
    int wt;
    int arr[];
    int values[];
    int weights[];
    float res[];
    float profit;
    Knap(int arr[], int values[],int weights[],int wt){
        this.wt=wt;
        this.arr = arr;
        this.values=values;
        this.weights=weights;
        res=new float[arr.length];
        profit=0;
    }
    void ks(){
        for(int i=0;i<arr.length;i++){
            res[i]=(float)values[i]/weights[i];
        }
        sort();

        for(int i=0;i<arr.length;i++){
            if(weights[i]<=wt){
                profit+=(float)values[i];
                wt-=weights[i];
            }
            else if(weights[i]>wt && wt!=0 ){
                profit+=((float)(wt/weights[i]))*values[i];
                wt=0;
            }

        }
        System.out.println("profit ="+profit);





    }
    void sort(){
        for (int i = 0; i < arr.length-1; i++) {
            for(int j=i+1;j<arr.length;j++){
                if(res[j]>res[i]){
                    float temp=res[i];
                    res[i]=res[j];
                    res[j]=temp;

                    int temp2=values[i];
                    values[i]=values[j];
                    values[j]=temp2;

                    int temp3=weights[i];
                    weights[i]=weights[j];
                    weights[j]=temp3;
                }

            }
        }
    }
}
public class FracKnap {
    public static void main(String args[]){
        int arr[]={3,5,4,6};
        int values[]={10,8,12,5};
        int weights[]={5,2,3,4};
        int wt=12;
        Knap obj=new Knap(arr, values, weights,wt);
        obj.ks();

    }
}
