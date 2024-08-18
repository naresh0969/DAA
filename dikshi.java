import java.util.*;
class Dijkstra {
    int[][] adj;
    int[] p;
    int[] v;
    int[] c;
    int parent;

    Dijkstra(int n, Scanner s) {
        p = new int[n];
        v = new int[n];
        c = new int[n];
        adj = new int[n][n];
        System.out.println("Enter the adjacency matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    System.out.print("Edge between " + i + " and " + j + ": ");
                    adj[i][j] = adj[j][i] = s.nextInt();
                } else {
                    adj[i][j] = 0;
                }
            }
        }

        System.out.print("Enter the parent (source vertex): ");
        parent = s.nextInt();

        for (int i = 0; i < n; i++) {
            v[i] = -1;
            c[i] = Integer.MAX_VALUE;
        }
        v[parent] = 1;
        c[parent] = 0;

        for (int j = 0; j < n; j++) {
            if (adj[parent][j] != 0) {
                c[j] = adj[parent][j];
                p[j] = parent;
            }
        }
    }

    void cost(int n) {
        int k = n - 1;
        while (k > 0) {
            int index = -1; 
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (v[i] == -1 && c[i] < min) {
                    min = c[i];
                    index = i;
                }
            }

            // if (index == -1) break;

            v[index] = 1;

            for (int j = 0; j < n; j++) {
                if (adj[index][j] != 0 && v[j] == -1 && c[j] > c[index] + adj[index][j]) {
                    c[j] = c[index] + adj[index][j];
                }
            }
            k--;
        }
    }

    void print(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Cost of vertex " + i + ": " + c[i]);
        }
    }

}

class dikshi{
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = s.nextInt();
        Dijkstra d = new Dijkstra(n, s);
        d.cost(n);
        d.print(n);
        s.close();
    }
}
