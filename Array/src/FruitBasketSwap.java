import java.util.*;

public class FruitBasketSwap {
    public long minCostToMakeBasketsEqual(int[] basket1, int[] basket2) {
        int n = basket1.length;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int cost : basket1) {
            countMap.put(cost, countMap.getOrDefault(cost, 0) + 1);
        }
        for (int cost : basket2) {
            countMap.put(cost, countMap.getOrDefault(cost, 0) - 1);
        }

        List<Integer> excess = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int freq = entry.getValue();
            if (freq % 2 != 0) {
                return -1;
            }
            for (int i = 0; i < Math.abs(freq) / 2; i++) {
                excess.add(entry.getKey());
            }
        }

        Collections.sort(excess);
        int minValue = Math.min(Arrays.stream(basket1).min().getAsInt(), Arrays.stream(basket2).min().getAsInt());

        long cost = 0;
        for (int i = 0; i < excess.size() / 2; i++) {
            cost += Math.min(excess.get(i), 2 * minValue);
        }

        return cost;
    }
}
