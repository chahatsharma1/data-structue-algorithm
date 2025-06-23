import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String str : tokens){
            if(isOperator(str)){
                int second = stack.pop();
                int first = stack.pop();
                int ans = solve(first, second, str);
                stack.push(ans);
            } else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String sign){
        return sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/");
    }

    private int solve(int first, int second, String sign){
        return switch(sign) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> throw new IllegalArgumentException("Invalid");
        };
    }
}
