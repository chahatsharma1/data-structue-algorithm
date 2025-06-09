public class KSmallestLexicographical {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k -= 1;

        while (k > 0){
            long steps = count(n, current, current + 1);

            if (steps > k){
                current *= 10;
                k -= 1;
            } else {
                current++;
                k -= (int) steps;
            }
        }
        return current;
    }
    private long count(int n, int current, int next){
        long steps = 0;

        while (current <= n){
            steps += Math.min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }
        return steps;
    }
}
