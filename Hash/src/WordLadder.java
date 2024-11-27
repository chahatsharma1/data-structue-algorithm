import java.util.*;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current != null) {
                    for (int j = 0; j < current.length(); j++) {
                        char[] temp = current.toCharArray();
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            temp[j] = ch;
                            String newWord = new String(temp);
                            if (newWord.equals(endWord)) {
                                return count + 1;
                            }

                            if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                                queue.offer(newWord);
                                visited.add(newWord);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}