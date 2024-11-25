import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids){
            boolean exploded = false;

            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0){
                if (Math.abs(asteroid) > Math.abs(stack.peek())){
                    stack.pop();
                } else if (Math.abs(asteroid) == Math.abs(stack.peek())) {
                    stack.pop();
                    exploded = true;
                    break;
                } else {
                    exploded = true;
                    break;
                }
            }
            if (!exploded){
                stack.push(asteroid);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--){
            ans[i] = stack.pop();
        }

        return ans;
    }
}
