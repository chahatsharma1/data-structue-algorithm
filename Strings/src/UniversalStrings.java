import java.util.ArrayList;
import java.util.List;

public class UniversalStrings {
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        int[] words2Freq = new int[26];

        for (String s : words2){
            int[] freq = countFreq(s);
            for (int i = 0; i < 26; i++) {
                words2Freq[i] = Math.max(words2Freq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String a : words1){
            int[] freq = countFreq(a);
            if (isUniversal(freq, words2Freq)){
                ans.add(a);
            }
        }
        return ans;
    }

    private static int[] countFreq(String a) {
        int[] freq = new int[26];
        for (char ch : a.toCharArray()){
            freq[ch - 'a']++;
        }
        return freq;
    }

    private static boolean isUniversal(int[] freq, int[] words2Freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] < words2Freq[i]){
                return false;
            }
        }
        return true;
    }
}
