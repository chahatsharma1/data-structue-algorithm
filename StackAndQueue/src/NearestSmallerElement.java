import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.size(); i++) {
            while(!stack.isEmpty() && stack.peek() >= A.get(i)){
                stack.pop();
            }

            if (stack.isEmpty()){
                ans.add(i, -1);
            }
            else {
                ans.add(i, stack.peek());
            }
            stack.push(A.get(i));
        }
        return ans;
    }
}