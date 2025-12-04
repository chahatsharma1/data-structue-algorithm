public class CountCollisionsOnARoad {
    public int countCollisions(String directions) {
        int n = directions.length();
        int collisions = 0;

        int i = 0;
        while (i < n && directions.charAt(i) == 'L') {
            i++;
        }

        int j = n - 1;
        while (j >= 0 && directions.charAt(j) == 'R') {
            j--;
        }

        for (int k = i; k <= j; k++) {
            if (directions.charAt(k) != 'S') {
                collisions++;
            }
        }
        return collisions;
    }
}