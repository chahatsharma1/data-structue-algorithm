public class NextNumericallyBalancedNumber {
    public int nextBeautifulNumber(int n) {
        int x = n + 1;
        while (true) {
            if (isBalanced(x)) {
                return x;
            }
            x++;
        }
    }

    private boolean isBalanced(int num) {
        int[] count = new int[10];
        char[] digits = String.valueOf(num).toCharArray();

        for (char ch : digits) {
            count[ch - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            if (count[i] != 0 && count[i] != i) {
                return false;
            }
        }

        return true;
    }
}
