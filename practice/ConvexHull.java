import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class ConvexHull {

    // Method to determine the orientation of the triplet (p, q, r).
    // The function returns:
    // 0 : Collinear points
    // 1 : Clockwise points
    // 2 : Counterclockwise points
    public static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0;  // collinear
        return (val > 0) ? 1 : 2; // clock or counterclockwise
    }

    // Function to find convex hull using brute force approach
    public static List<Point> convexHull(Point[] points) {
        int n = points.length;
        if (n < 3) return new ArrayList<>(); // Convex hull is not possible

        List<Point> hull = new ArrayList<>();

        // Iterate through all points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean allLeft = true;

                // Check if all other points are on the left of the line formed by points[i] and points[j]
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    if (orientation(points[i], points[j], points[k]) == 1) {
                        allLeft = false;
                        break;
                    }
                }

                if (allLeft) {
                    hull.add(points[i]);
                    hull.add(points[j]);
                }
            }
        }

        // Remove duplicates from the hull
        List<Point> uniqueHull = new ArrayList<>();
        for (Point p : hull) {
            if (!uniqueHull.contains(p)) {
                uniqueHull.add(p);
            }
        }

        return uniqueHull;
    }

    public static void main(String[] args) {
        Point[] points = {new Point(0, 3), new Point(2, 2), new Point(1, 1), new Point(2, 1), 
                          new Point(3, 0), new Point(0, 0), new Point(3, 3)};

        List<Point> hull = convexHull(points);

        System.out.println("The points in the Convex Hull are:");
        for (Point p : hull) {
            System.out.println(p);
        }
    }
}