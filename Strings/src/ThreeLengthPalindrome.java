import java.util.HashSet;
import java.util.Set;

public class ThreeLengthPalindrome {
    public int countPalindrome(String s){
        int n = s.length();
        if (n < 3){
            return 0;
        }

        Set<Character> left = new HashSet<>();
        int[] right = new int[26];

        for (char ch : s.toCharArray()){
            right[ch - 'a']++;
        }

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++){
            char middle = s.charAt(i);
            right[middle - 'a']--;

            for (char ch : left){
                if (right[ch - 'a'] > 0){
                    set.add("" + ch + middle + ch);
                }
            }
            left.add(middle);
        }
        return set.size();
    }
}
