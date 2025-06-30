import java.util.HashMap;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for(int num : nums){
            if(map.containsKey(num + 1)){
                int current = map.get(num) + map.get(num + 1);
                ans = Math.max(ans, current);
            }
        }
        return ans;
    }
}