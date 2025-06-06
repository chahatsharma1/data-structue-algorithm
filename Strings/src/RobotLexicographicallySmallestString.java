import java.util.ArrayDeque;
import java.util.Deque;

public class RobotLexicographicallySmallestString {
    public String robotWithString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] freq = new char[26];
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : s.toCharArray()){
            ++freq[ch - 'a'];
        }

        for (char ch : s.toCharArray()){
            deque.push(ch);
            --freq[ch - 'a'];

            char min = getMin(freq);

            while (!deque.isEmpty() && deque.peek() <= min){
                sb.append(deque.pop());
            }
        }

        while (!deque.isEmpty()){
            sb.append(deque.pop());
        }

        return sb.toString();
    }

    private char getMin(char[] freq){
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0){
                return (char) ('a' + i);
            }
        }
        return 'a';
    }
}
