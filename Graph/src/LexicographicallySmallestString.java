import java.util.*;

public class LexicographicallySmallestString {
    public static String findLexSmallestString(String s, int a, int b) {
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String smallest = s;

        queue.offer(s);
        seen.add(s);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }

            char[] chars = curr.toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
            }
            String added = new String(chars);

            if (seen.add(added)) {
                queue.offer(added);
            }

            String rotated = rotateRight(curr, b);
            if (seen.add(rotated)) {
                queue.offer(rotated);
            }
        }

        return smallest;
    }

    private static String rotateRight(String s, int b) {
        int n = s.length();
        b = b % n;
        return s.substring(n - b) + s.substring(0, n - b);
    }
}