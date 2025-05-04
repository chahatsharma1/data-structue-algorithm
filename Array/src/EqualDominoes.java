import java.util.HashMap;

public class EqualDominoes {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] domino : dominoes) {
            int a = domino[0], b = domino[1];
            String key = a < b ? a + "," + b : b + "," + a;

            int freq = map.getOrDefault(key, 0);
            count += freq;
            map.put(key, freq + 1);
        }
        return count;
    }
}
