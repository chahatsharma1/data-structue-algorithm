import java.util.HashMap;

public class MinWindowSubString {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.isEmpty()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int minStart = 0;
        int count = 0;
        int length = Integer.MAX_VALUE;
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char endCh = s.charAt(end);
            windowMap.put(endCh, windowMap.getOrDefault(endCh, 0) + 1);

            if (map.containsKey(endCh) && windowMap.get(endCh) <= map.get(endCh)){
                count++;
            }

            while (t.length() == count){
                if (end - start + 1 < length){
                    length = end - start + 1;
                    minStart = start;
                }

                char startChar = s.charAt(start);
                windowMap.put(startChar, windowMap.get(startChar) - 1);

                if (map.containsKey(startChar) && windowMap.get(startChar) < map.get(startChar)){
                    count--;
                }
                start++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + length);
    }
}
