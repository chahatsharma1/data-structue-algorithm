import java.util.*;

public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        int palindromeLength = 0;
        boolean hasOddFrequency = false;

        for (int count : charFrequency.values()) {
            if (count % 2 == 0) {
                palindromeLength += count;
            } else {
                palindromeLength += count - 1;
                hasOddFrequency = true;
            }
        }

        if (hasOddFrequency) {
            palindromeLength++;
        }

        return palindromeLength;
    }
}
