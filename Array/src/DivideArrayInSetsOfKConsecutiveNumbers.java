import java.util.TreeMap;

public class DivideArrayInSetsOfKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0){
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()){
            int first = map.firstKey();
            for(int i = 0; i < k; i++){
                int nextNum = first + i;

                if (!map.containsKey(nextNum)){
                    return false;
                }

                map.put(nextNum, map.get(nextNum) - 1);
                if (map.get(nextNum) == 0){
                    map.remove(nextNum);
                }
            }
        }
        return true;
    }
}