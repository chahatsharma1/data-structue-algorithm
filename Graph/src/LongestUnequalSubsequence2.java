import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestUnequalSubsequence2 {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
            for (int j = i + 1; j < n; j++) {
                if (groups[i] != groups[j] && words[i].length() == words[j].length() && hammingDistance(words[i], words[j])){
                    graph[i].add(j);
                }
            }
        }

        int[] dp = new int[n];
        int[] next = new int[n];
        int max = 0;
        int startIndex = 0;
        Arrays.fill(dp, -1);
        Arrays.fill(next, -1);


        for (int i = 0; i < n; i++){
            int length = dfs(i, dp, next, graph);
            if (length > max){
                max = length;
                startIndex = i;
            }
        }
        List<String> result = new ArrayList<>();
        while (startIndex != -1){
            result.add(words[startIndex]);
            startIndex = next[startIndex];
        }
        return result;
    }

    private int dfs(int i, int[] dp, int[] next, List<Integer>[] graph) {
        if (dp[i] != -1){
            return dp[i];
        }
        int max = 1;
        int nextIndex = -1;

        for(int a : graph[i]){
            int length = 1 + dfs(a, dp, next, graph);
            if (length > max){
                max = length;
                nextIndex = a;
            }
        }

        dp[i] = max;
        next[i] = nextIndex;
        return max;
    }

    private boolean hammingDistance(String word, String word1) {
        int count = 0;
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) != word1.charAt(i)){
                count++;
            }
            if (count > 1){
                return false;
            }
        }
        return count == 1;
    }
}
