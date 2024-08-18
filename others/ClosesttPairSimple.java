import java.util.Arrays;

class ClosestPairSimple {

    // Class to represent a point in 2D space
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Method to calculate the distance between two points
    static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    // A simple method to find the smallest distance between any two points in an array
    static double bruteForce(Point[] points, int n) {
        double minDist = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = distance(points[i], points[j]);
                if (dist < minDist) {
                    minDist = dist;
                }
            }
        }
        return minDist;
    }

    // Method to find the closest pair of points using divide and conquer
    static double closestPair(Point[] points, int left, int right) {
        // If there are 2 or 3 points, use brute force to find the closest pair
        if (right - left <= 3) {
            return bruteForce(points, right - left + 1);
        }

        // Find the middle point
        int mid = (left + right) / 2;
        Point midPoint = points[mid];

        // Recursively find the smallest distance in the left and right halves
        double dl = closestPair(points, left, mid);
        double dr = closestPair(points, mid + 1, right);

        // Find the smaller of the two distances
        double d = Math.min(dl, dr);

        // Create an array to hold points that are within distance d of the middle line
        Point[] strip = new Point[right - left + 1];
        int j = 0;
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - midPoint.x) < d) {
                strip[j++] = points[i];
            }
        }

        // Find the closest points in the strip
        double minStripDist = bruteForce(strip, j);

        // Return the overall minimum distance
        return Math.min(d, minStripDist);
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        Point[] points = {
            new Point(2, 3),
            new Point(12, 30),
            new Point(40, 50),
            new Point(5, 1),
            new Point(12, 10),
            new Point(3, 4)
        };

        // Sort the points according to x-coordinates (simple version using Arrays.sort)
        Arrays.sort(points, (p1, p2) -> p1.x - p2.x);

        int n = points.length;

        // Find and print the smallest distance
        double result = closestPair(points, 0, n - 1);
        System.out.println("The smallest distance is " + result);
    }
}
