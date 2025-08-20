public class PrefixTree {
    public PrefixTreeNode root;

    public PrefixTree() {
        root = new PrefixTreeNode();
    }

    public void insert(String word) {
        PrefixTreeNode prefixTreeNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (!prefixTreeNode.containsKey(word.charAt(i))) {
                prefixTreeNode.put(word.charAt(i), new PrefixTreeNode());
            }
            prefixTreeNode = prefixTreeNode.get(word.charAt(i));
        }
        prefixTreeNode.setEnd();
    }

    public boolean search(String word) {
        PrefixTreeNode prefixTreeNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (!prefixTreeNode.containsKey(word.charAt(i))){
                 return false;
            }
            prefixTreeNode = prefixTreeNode.get(word.charAt(i));
        }
        return prefixTreeNode.isEnd();
    }

    public boolean startsWith(String prefix) {
        PrefixTreeNode prefixTreeNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!prefixTreeNode.containsKey(prefix.charAt(i))){
                return false;
            }
            prefixTreeNode = prefixTreeNode.get(prefix.charAt(i));
        }
        return true;
    }
}