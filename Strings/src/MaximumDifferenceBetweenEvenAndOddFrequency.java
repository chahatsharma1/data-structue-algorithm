import java.util.HashMap;

public class MaximumDifferenceBetweenEvenAndOddFrequency {
    public int maxDifference(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int num : map.values() ){
            if(num % 2 == 1){
                max = Math.max(max, num);
            } else {
                min = Math.min(min, num);
            }
        }

        if (max == Integer.MIN_VALUE || min == Integer.MAX_VALUE) {
            return -1;
        }

        return max- min;
    }
}