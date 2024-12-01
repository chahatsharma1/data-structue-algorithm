import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestion {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        Arrays.sort(products);

        for (String product : products){
            insert(product, root);
        }

        List<List<String>> ans = new ArrayList<>();

        Trie current = root;
        for (char ch : searchWord.toCharArray()){
            if (current != null){
                current = current.child.get(ch);
                ans.add(current == null ? new ArrayList<>() : current.suggestion);
            }
        }
        return ans;
    }

    private void insert(String product, Trie root){
        Trie current = root;
        for (char ch : product.toCharArray()){
            current.child.putIfAbsent(ch, new Trie());
            current = current.child.get(ch);
            if (current.suggestion.size() < 3){
                current.suggestion.add(product);
            }
        }
    }
}
