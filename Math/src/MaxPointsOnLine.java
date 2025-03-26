import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {
    public int maxPoints(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        int maxPoints = 1;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 0;
            int vertical = 0;
            int localMax = 1;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    // If both x and y differences are 0, it's a duplicate point
                    duplicate++;
                } else if (dx == 0) {
                    // If x difference is 0, it's a vertical line
                    vertical++;
                    localMax = Math.max(localMax, vertical + 1); // +1 for the initial point
                } else {
                    // Reduce fraction using GCD
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;
                    
                    // Store slope as a fraction (dy/dx)
                    String slope = dy + "/" + dx;
                    slopeMap.put(slope, slopeMap.getOrDefault(slope, 1) + 1);
                    localMax = Math.max(localMax, slopeMap.get(slope));
                }
            }

            // Consider duplicates and vertical lines
            maxPoints = Math.max(maxPoints, localMax + duplicate);
        }

        return maxPoints;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
