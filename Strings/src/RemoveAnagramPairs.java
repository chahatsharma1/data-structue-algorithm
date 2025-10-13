import java.util.*;

public class RemoveAnagramPairs {
    public static List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (!result.isEmpty() && isAnagram(result.getLast(), word)) {
                continue;
            }
            result.add(word);
        }
        return result;
    }

    private static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int[] freq = new int[26];
        for (char c : a.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : b.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}