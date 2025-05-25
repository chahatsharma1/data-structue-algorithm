import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeByConcatenating {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> wordFreq = new HashMap<>();
        int length = 0;
        boolean hasOddCenter = false;

        for (String word : words){
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        for (String word : wordFreq.keySet()){
            String reversed = new StringBuilder(word).reverse().toString();

            if (!word.equals(reversed)){
                if (wordFreq.containsKey(reversed)){
                    int pairCount = Math.min(wordFreq.get(word), wordFreq.get(reversed));
                    length += pairCount * 4;
                    wordFreq.put(word, wordFreq.get(word) - pairCount);
                    wordFreq.put(reversed, wordFreq.get(reversed) - pairCount);
                }
            } else {
                int count = wordFreq.get(word);
                length += (count / 2) * 4;
                if (count % 2 == 1){
                    hasOddCenter = true;
                }
            }
        }
        if (hasOddCenter){
            length += 2;
        }
        return length;
    }
}
