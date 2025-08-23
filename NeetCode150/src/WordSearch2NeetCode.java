import java.util.ArrayList;
import java.util.List;

public class WordSearch2NeetCode {
    public List<String> findWords(char[][] board, String[] words) {
        WordTrie root = buildTrie(words);
        List<String> ans = new ArrayList<>();

        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++) {
                backtrack(row, col, board, root, ans);
            }
        }
        return ans;
    }

    private WordTrie buildTrie(String[] words) {
        WordTrie root = new WordTrie();
        for (String word : words){
            WordTrie node = root;
            for (char ch : word.toCharArray()){
                int index = ch - 'a';
                if (node.children[index] == null){
                    node.children[index] = new WordTrie();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }

    private void backtrack(int row, int col, char[][] board, WordTrie node, List<String> ans) {
        char ch = board[row][col];

        if (ch == '#' || node.children[ch - 'a'] == null){
            return;
        }
        node = node.children[ch - 'a'];
        if (node.word != null){
            ans.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] dir : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length){
                backtrack(newRow, newCol, board, node, ans);
            }
        }
        board[row][col] = ch;
    }
}