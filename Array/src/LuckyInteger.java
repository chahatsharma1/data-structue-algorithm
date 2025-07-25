import java.util.HashMap;
import java.util.Map;

public class LuckyInteger {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey().intValue() == entry.getValue().intValue()) {
                max = Math.max(max, entry.getKey());
            }
        }
        return max;
    }
}