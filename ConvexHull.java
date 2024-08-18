import java.util.Scanner;

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ConvexHull {
    static int orientation(Point p, Point q, Point r) {
        int val =  (p.x - q.x) * (r.y - q.y) - (p.y - q.y) * (r.x - q.x) ;  //mathematically using cross product formula
        if (val == 0)
            return 0;
        return (val > 0) ? 1 : 2;
    }

    static void convexHull(Point points[], int n) {
        if (n < 3)
            return;
        int[] hullIndices = new int[n];
        int hullCount = 0;
        int leftmost = 0;
        for (int i = 0; i < n; i++) {  //to find the point with least x-coordinate
            if (points[i].x < points[leftmost].x)
                leftmost = i;
        }
        int p = leftmost, q;
        do {
            hullIndices[hullCount++] = p;
            q = (p + 1) % n;
            for (int i = 0; i < n; i++) { //here why i from 0 unlike from very next point from q? ans becoz inner loop must go through all points for any line segement considered as convex
                if(i == p || i==q){  //last edited & no matter with this line
                    continue;
                }
                if (orientation(points[p], points[i], points[q]) == 2)//here loop go through all points and every point is checked with convex
                    q = i;
            }
            p = q;
        } while (p != leftmost);
        System.out.println("Convex Hull:");
        for (int i = 0; i < hullCount; i++) {
            System.out.println("(" + points[hullIndices[i]].x + ", " + points[hullIndices[i]].y + ")");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        System.out.println("Enter the coordinates of each point (x, y):");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }
        convexHull(points, n);
        scanner.close();
    }
}

