import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return check(s).equals(check(t));
    }
    
    private String check(String str){
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()){
            if (ch != '#'){
                stack.push(ch);
                } else if (!stack.isEmpty()){
                stack.pop();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
