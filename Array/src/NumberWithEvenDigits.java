public class NumberWithEvenDigits {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int n : nums) {
            if (n >= 10 && n < 100 || n >= 1000 && n <= 9999 || n == 100000) {
                count++;
            }
        }
        return count;
    }
}