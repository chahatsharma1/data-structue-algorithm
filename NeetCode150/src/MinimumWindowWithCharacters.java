import java.util.HashMap;

public class MinimumWindowWithCharacters {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char ch : t.toCharArray()){
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int start = 0;
        int valid = 0;
        int minLength = Integer.MAX_VALUE;

        while(right < s.length()){
            char c = s.charAt(right);
            right++;

            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(need.get(c).intValue() == window.get(c).intValue()){
                    valid++;
                }
            }

            while(valid == need.size()){
                if(right - left < minLength){
                    minLength = right - left;
                    start = left;
                }

                char a = s.charAt(left);
                left++;

                if(need.containsKey(a)){
                    if(need.get(a).intValue() == window.get(a).intValue()){
                        valid--;
                    }
                    window.put(a, window.get(a) - 1);
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
} 