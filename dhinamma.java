import java.util.*;

class niyamma{
    int adj[][];
    int p[];
    int p1, p2;
    int value = 0;


    niyamma(int n){
        adj = new int[n][n];
        p = new int[n];
        Scanner sc = new Scanner(System.in);
        
       
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

     
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    System.out.print("Enter the value between " + i + " and " + j+": ");
                    adj[i][j] = adj[j][i] = sc.nextInt();
                } else {
                    adj[i][j] = adj[j][i] = -1;
                }
            }
        }
    }

    void find_cost(int n) {
        int k = 0;
        while (k < n - 1) {
            find_edge(n);
            if (p1 == -1 || p2 == -1) {
                System.out.println("No valid edge found. MST cannot be completed.");
                return;
            }
            int pu = findPar(p1);
            int pv = findPar(p2);
            if (pu != pv) {
                value += adj[p1][p2];
                p[pu] = pv;
                k++;
            }
            adj[p1][p2] = adj[p2][p1] = -1;
        }
        System.out.println("Total value of MST: " + value);
    }

    void find_edge(int n) {
        int min = Integer.MAX_VALUE;
        p1 = -1;
        p2 = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j] != -1 && adj[i][j] < min) {
                    p1 = i;
                    p2 = j;
                    min = adj[i][j];
                }
            }
        }
        System.out.println("Selected edge (" + p1 + ", " + p2 + ") with weight " + min);
        return;
    }

    int findPar(int n) {
        if (n == p[n]) {
            return n;
        }
        return p[n] = findPar(p[n]); 
    }
}

class dhinamma {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("enter the no  of the vertices:");
        int n=sc.nextInt();
        niyamma s=new niyamma(n);
        s.find_cost(n);
    }
}
