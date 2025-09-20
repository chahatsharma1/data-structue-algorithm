import java.util.*;

class DetectSquares {
    private final Map<Integer, Map<Integer, Integer>> countMap;

    public DetectSquares() {
        countMap = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        countMap.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = countMap.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];
        if (!countMap.containsKey(x)) {
            return 0;
        }

        int total = 0;
        Map<Integer, Integer> yMap = countMap.get(x);

        for (int ny : yMap.keySet()) {
            if (ny == y) {
                continue;
            }

            int side = ny - y;
            total += checkSquare(x, y, x + side, y, x + side, ny) * yMap.get(ny);
            total += checkSquare(x, y, x - side, y, x - side, ny) * yMap.get(ny);
        }

        return total;
    }

    private int checkSquare(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (!countMap.containsKey(x2) || !countMap.containsKey(x3)) {
            return 0;
        }

        int c1 = countMap.get(x2).getOrDefault(y2, 0);
        int c2 = countMap.get(x3).getOrDefault(y3, 0);

        return c1 * c2;
    }
}
