import java.util.ArrayList;
import java.util.List;

public class SumOfKMirrorNumbers {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int len = 1;

        while (count < n) {
            for (long num : generatePalindromes(len)) {
                if (isPalindrome(toBaseK(num, k))) {
                    sum += num;
                    count++;
                    if (count == n) {
                        return sum;
                    }
                }
            }
            len++;
        }

        return sum;
    }

    private List<Long> generatePalindromes(int len) {
        List<Long> palindromes = new ArrayList<>();

        int start = (int) Math.pow(10, (len - 1) / 2);
        int end = (int) Math.pow(10, (len + 1) / 2);

        for (int i = start; i < end; i++) {
            String firstHalf = Integer.toString(i);
            String secondHalf = new StringBuilder(firstHalf.substring(0, len / 2)).reverse().toString();
            palindromes.add(Long.parseLong(firstHalf + secondHalf));
        }

        return palindromes;
    }

    private String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}