import java.util.LinkedList;
import java.util.Queue;

public class MaxCandyFromTheBox {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] hasBox = new boolean[n];
        boolean[] opened = new boolean[n];
        boolean[] hasKey = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int box : initialBoxes){
            hasBox[box] = true;
            if (status[box] == 1){
                queue.offer(box);
                opened[box] = true;
            }
        }

        int total = 0;
        while (!queue.isEmpty()){
            int current = queue.poll();
            total += candies[current];

            for (int key : keys[current]){
                hasKey[key] = true;
                if (hasBox[key] && !opened[key]){
                    queue.offer(key);
                    opened[key] = true;
                }
            }

            for (int containedBox : containedBoxes[current]){
                hasBox[containedBox] = true;
                if ((status[containedBox] == 1 || hasKey[containedBox]) && !opened[containedBox]){
                    queue.offer(containedBox);
                    opened[containedBox] = true;
                }
            }
        }
        return total;
    }
}
