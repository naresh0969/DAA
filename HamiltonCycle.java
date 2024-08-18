import java.util.Scanner;

class Track{
    int n;  
    int a[];
    int edge[][];
    Track(int n, Scanner sc){
        this.n = n;
        this.a = new int[n];
        this.edge = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                System.out.print("edge between "+i+" and "+j+" :");
                edge[i][j] = edge[j][i] = sc.nextInt();
            }
        }
        a[0] = 0;
        hamilton(1, n);
    }
    void hamilton(int pos, int n){
        if(pos == n){
            for(int i=0; i<n; i++){
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }
        for(int i=1; i<n; i++){
            if(isSafe(pos, i)){
                a[pos] = i;
                hamilton(pos+1, n);
            }
        }
    }
    boolean isSafe(int pos, int node){
        for(int i=0; i<pos; i++){
            if(a[i] == node){
                return false;
            }
        }
        if(edge[a[pos-1]][node] != 1){
            return false;
        }
        if(pos == n-1 && edge[node][a[0]] != 1){
            return false;
        }
        return true;
    }
}
public class HamiltonCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=6;
        new Track(n, sc);

        sc.close();
    }
}
