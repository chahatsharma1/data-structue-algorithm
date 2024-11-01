import java.util.Arrays;
import java.util.Comparator;

public class BurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int countArrow = 1;
        int currentArrow = points[0][1];

        for (int i = 1; i < points.length; i++){
            if (points[i][0] > currentArrow){
                countArrow++;
                currentArrow = points[i][1];
            }
        }
        return countArrow;
    }
}
