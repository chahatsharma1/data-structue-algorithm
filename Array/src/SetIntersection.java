import java.util.*;

public class SetIntersection {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> 
            a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );

        int p1 = -1, p2 = -1;
        int count = 0;

        for (int[] it : intervals) {
            int start = it[0], end = it[1];

            boolean hasP1 = (p1 >= start);
            boolean hasP2 = (p2 >= start);

            if (hasP1 && hasP2) {
                continue;
            }

            if (hasP2) {
                count++;
                p1 = p2;
            }
            else {
                count += 2;
                p1 = end - 1;
            }
            p2 = end;
        }
        return count;
    }
}