import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortVowels {
    public String sortVowels(String s) {
        String vowels = "aeiouAEIOU";
        StringBuilder result = new StringBuilder();

        List<Character> vowelList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                vowelList.add(c);
            }
        }

        Collections.sort(vowelList);

        int index = 0;
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                result.append(vowelList.get(index++));
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}