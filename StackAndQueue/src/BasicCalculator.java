import java.util.Stack;

public class BasicCalculator {
    public int calculator(String s){
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        int ans = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)){
                currentNumber = currentNumber * 10 + (ch - '0');
            } else if (ch == '+') {
                ans += sign * currentNumber;
                currentNumber = 0;
                sign = 1;
            } else if (ch == '-'){
                ans += sign * currentNumber;
                currentNumber = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            } else if (ch == ')'){
                ans += sign * currentNumber;
                ans *= stack.pop();
                ans += stack.pop();
                currentNumber = 0;
            }
        }
        if (currentNumber != 0){
            ans += currentNumber * sign;
        }
        return ans;
    }
}
