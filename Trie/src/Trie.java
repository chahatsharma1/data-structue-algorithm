import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
    HashMap<Character, Trie> child = new HashMap<>();
    ArrayList<String> suggestion = new ArrayList<>();
}
