import java.util.ArrayList;
import java.util.List;

public class RemovingStars {
    public String clearStars(String s) {
        StringBuilder sb = new StringBuilder(s);
        List<Integer>[] bucket = new List[26];

        for (int i = 0; i < 26; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '*'){
                sb.setCharAt(i, ' ');
                int j = 0;
                while (bucket[j].isEmpty()){
                    ++j;
                }
                sb.setCharAt(bucket[j].removeLast(), ' ');
            } else {
                bucket[s.charAt(i) - 'a'].add(i);
            }
        }
        return sb.toString().replace(" ", "");
    }
}
