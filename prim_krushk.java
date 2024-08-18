import java.util.*;
class krushkal{
    int adj[][];
    int parent[];
    krushkal(int n,Scanner s){
        parent=new int[n];
        adj=new int[n][n];
        System.out.println("enter the adjacent matrix:");
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                System.out.print("edge between "+i+" and "+j+" :");
                if(i!=j){
                    adj[i][j] = adj[j][i] = s.nextInt();
                }
            }
        }
    }
    int prims(int visited[],int n){
        int k=n-1,cost=0;
        while(k>0){
            int min=10000;
            int p=-1,c=-1;
            for(int i=0;i<n;i++){
                if(visited[i]==1){
                    for(int j=0;j<n;j++){
                        if(visited[j]!=1 && adj[i][j]!=0){
                            if(min>adj[i][j]){
                                min=adj[i][j];
                                p=i;
                                c=j;
                            }
                        }
                    }
                }
            }
            if (c == -1) break;
            visited[c]=1;
            parent[c]=p;
            cost+=adj[p][c];
            k--;
        }
        return cost;
    }
    void par(int n){
        for(int i=0;i<n;i++){
            System.out.println(parent[i]);
        }
        
    }
}


class prim_krushk {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        krushkal k=new krushkal(n, s);
        int visited[] = new int[n];
        visited[0] = 1;
        System.out.println(k.prims(visited,n));
        k.par(n);
    }
}
