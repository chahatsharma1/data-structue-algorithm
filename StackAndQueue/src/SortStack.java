import java.util.Stack;

public class SortStack {
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()){
            return;
        }

        int top = stack.pop();
        sortStack(stack);

        sorting(stack, top);
    }

    private static void sorting(Stack<Integer> stack, int top) {
        if (stack.isEmpty() || top > stack.peek()) {
            stack.push(top);
            return;
        }

        int element = stack.pop();

        sorting(stack, top);

        stack.push(element);
    }
}
