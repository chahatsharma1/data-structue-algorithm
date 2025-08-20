public class PrefixTreeNode {
    PrefixTreeNode[] links = new PrefixTreeNode[26];
    boolean flag = false;

    public PrefixTreeNode() { }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, PrefixTreeNode prefixTreeNode) {
        links[ch - 'a'] = prefixTreeNode;
    }

    public PrefixTreeNode get(char ch) {
        return links[ch - 'a'];
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}