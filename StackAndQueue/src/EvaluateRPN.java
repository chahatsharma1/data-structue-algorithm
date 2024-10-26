import java.util.Stack;

public class EvaluateRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens){
            if (isOperator(token)){
                int second = stack.pop();
                int first = stack.pop();
                int ans = evaluate(first, second, token);
                stack.push(ans);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String token){
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int evaluate(int first, int second, String token){
        return switch (token) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> throw new IllegalArgumentException("Invalid");
        };
    }
}