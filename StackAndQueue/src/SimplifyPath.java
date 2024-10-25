import java.util.Stack;

class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/");

        for (String str : strings){
            if (str.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else if (!str.equals(".") && !str.isEmpty()){
                stack.push(str);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : stack){
            stringBuilder.append("/").append(str);
        }

        return !stringBuilder.isEmpty() ? stringBuilder.toString() : "/";
    }

    public static void main(String[] args) {
        String path = "/.../a/../b/c/../d/./";
        System.out.println(simplifyPath(path));
    }
}