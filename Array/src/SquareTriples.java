public class SquareTriples {
    public int countTriples(int n) {
        int count = 0;

        int[] square = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            square[i] = i * i;
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int sum = square[a] + square[b];

                int c = (int) Math.sqrt(sum);
                if (c <= n && c * c == sum) {
                    count++;
                }
            }
        }
        return count;
    }
}