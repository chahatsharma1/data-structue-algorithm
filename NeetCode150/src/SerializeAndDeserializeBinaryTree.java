import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    private void encode(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null").append(",");
            return;
        }

        sb.append(node.val).append(",");
        encode(node.left, sb);
        encode(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, data.split(","));
        Collections.reverse(list);
        return decode(list);
    }

    private TreeNode decode(List<String> list){
        String value = list.removeLast();
        if (value.equals("null")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = decode(list);
        node.right = decode(list);
        return node;
    }
}
