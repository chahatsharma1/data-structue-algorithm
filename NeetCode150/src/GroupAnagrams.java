import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> group = new HashMap<>();

        for (String str : strings){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if(!group.containsKey(sortedWord)){
                group.put(sortedWord, new ArrayList<>());
            }

            group.get(sortedWord).add(str);
        }
        return new ArrayList<>(group.values());
    }
}
