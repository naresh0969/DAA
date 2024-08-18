package practice;
import java.util.Scanner;
class Hamilton{
    int edges[][];
    int path[];
    int nodes;
    Hamilton(int nodes,Scanner sc){
        path=new int [nodes];
        this.edges=new int[nodes][nodes];
        this.nodes=nodes;
        for(int i=0;i<nodes;i++){
            for(int j=i+1;j<nodes;j++){
                System.out.println("Enter the edge of"+i+"and"+j);
                edges[i][j]=sc.nextInt();
                edges[j][i]=edges[i][j];
            }
            path[i]=-1;
        }
        path[0]=0;
    }
    void cycle(int pos){
        if(pos==nodes){
            if(edges[path[pos-1]][path[0]]==1){
                for(int i=0;i<nodes;i++){
                    System.out.print(path[i]+" ");
                }
                System.out.println(path[0]);
            }
            
        }
        for(int i=1;i<nodes;i++){
            if(isSafe(pos,i)){
                path[pos]=i;
                cycle(pos+1);
                path[i]=-1;
                

            }

        }

    }
    boolean isSafe(int pos,int node){
        for(int i=0;i<pos;i++){
            if(path[i]==node) {
                return false;
            }
        }
        if(edges[path[pos-1]][node]!=1) return false;
        if(pos==nodes-1 && edges[node][path[0]]!=1) return false;
        return true;
    }
    
}

public class test {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int nodes=4;
        Hamilton obj=new Hamilton(nodes,sc);
        obj.cycle(1);
        sc.close();



    }
}
