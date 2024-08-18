import java.util.Scanner;
class Solution{
    int adj[][];
    int nodes;
    int p[],v[],c[];
    Solution(int nodes,Scanner sc){
        this.nodes=nodes;
        System.out.println("Enter weights");
        for(int i=0;i<nodes;i++){
            for(int j=0;j<nodes;j++){
                if(i==0&&j==0){
                    adj[i][j]=0;
                }
                else{
                    System.out.println("enter "+i+","+j+"weight");
                    adj[i][j]=sc.nextInt();
                }

            }
        }
        for(int i=0;i<nodes;i++){
            v[i]=-1;
            c[i]=Integer.MAX_VALUE;
        }
        System.out.println("Enter Source node :");
        int index=sc.nextInt();
        c[index]=0;
        v[index]=1;
        for(int j=0;j<nodes;j++){
            if(adj[index][j]!=0 && c[j]<adj[index][j]){
                c[j]=adj[index][j];
            }
        }

        
        int next=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nodes;i++){
            if(adj[index][i] !=0 && adj[index][i]<min){
                min=adj[index][i];
                next=i;

            }

        }
        v[next]=1;


    }
}
public class Dijkstra {
    public static void main(String args[]){
        int nodes;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no. vetices :");
        nodes=sc.nextInt();
        Solution obj=new Solution(nodes,sc);

    }
}
