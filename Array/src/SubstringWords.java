import java.util.*;

public class SubstringWords {
    public static List<String> stringMatching(String[] words) {
        Set<String> resultSet = new HashSet<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && words[j].contains(words[i])) {
                    resultSet.add(words[i]);
                    break;
                }
            }
        }
        return new ArrayList<>(resultSet);
    }
}
