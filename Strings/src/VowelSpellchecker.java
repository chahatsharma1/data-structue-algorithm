import java.util.*;

public class VowelSpellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitiveMap = new HashMap<>();
        Map<String, String> vowelInsensitiveMap = new HashMap<>();

        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            caseInsensitiveMap.putIfAbsent(lower, word);

            String devoweled = devowel(lower);
            vowelInsensitiveMap.putIfAbsent(devoweled, word);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (exactWords.contains(query)) {
                result[i] = query;
                continue;
            }

            String lowerQuery = query.toLowerCase();
            if (caseInsensitiveMap.containsKey(lowerQuery)) {
                result[i] = caseInsensitiveMap.get(lowerQuery);
                continue;
            }

            String devoweledQuery = devowel(lowerQuery);
            if (vowelInsensitiveMap.containsKey(devoweledQuery)) {
                result[i] = vowelInsensitiveMap.get(devoweledQuery);
                continue;
            }

            result[i] = "";
        }

        return result;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}