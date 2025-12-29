import java.util.*;

public class PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();

        for (String s : allowed) {
            String key = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }

        Set<String> memo = new HashSet<>();
        return dfs(bottom, map, memo);
    }

    private boolean dfs(String bottom, Map<String, List<Character>> map, Set<String> memo) {
        if (bottom.length() == 1) {
            return true;
        }

        if (memo.contains(bottom)) {
            return false;
        }

        List<String> nextRows = new ArrayList<>();
        buildNextRows(bottom, 0, new StringBuilder(), map, nextRows);

        for (String next : nextRows) {
            if (dfs(next, map, memo)) {
                return true;
            }
        }

        memo.add(bottom);
        return false;
    }

    private void buildNextRows(String bottom, int index, StringBuilder current, Map<String, List<Character>> map, List<String> result) {
        if (index == bottom.length() - 1) {
            result.add(current.toString());
            return;
        }

        String key = bottom.substring(index, index + 2);
        if (!map.containsKey(key)) {
            return;
        }

        for (char c : map.get(key)) {
            current.append(c);
            buildNextRows(bottom, index + 1, current, map, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}