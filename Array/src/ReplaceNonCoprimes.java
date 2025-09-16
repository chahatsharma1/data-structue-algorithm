import java.util.*;

public class ReplaceNonCoprimes {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();

        for (int num : nums) {
            stack.add(num);

            while (stack.size() > 1) {
                int a = stack.get(stack.size() - 2);
                int b = stack.getLast();

                int gcd = gcd(a, b);
                if (gcd > 1) {
                    stack.removeLast();
                    stack.removeLast();

                    long lcm = (long) a * b / gcd;
                    stack.add((int) lcm);
                } else {
                    break;
                }
            }
        }
        return stack;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
