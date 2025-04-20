import java.util.*;

public class RabbitInForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }

        int totalRabbits = 0;

        for (int x : map.keySet()) {
            int count = map.get(x);
            int groupSize = x + 1;
            int groups = (count + x) / groupSize;

            totalRabbits += groups * groupSize;
        }
        return totalRabbits;
    }
}
