import java.util.List;

public class StringTransformation2 {
    int MOD = 1_000_000_007;

    public int transformedLength(String s, int t, List<Integer> nums) {
        long[] count = new long[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int step = 0; step < t; step++) {
            long[] nextCount = new long[26];

            for (int i = 0; i < 26; i++) {
                if (count[i] == 0) continue;

                int len = nums.get(i);
                for (int j = 1; j <= len; j++) {
                    int newChar = (i + j) % 26;
                    nextCount[newChar] = (nextCount[newChar] + count[i]) % MOD;
                }
            }

            count = nextCount;
        }

        long result = 0;
        for (long c : count) {
            result = (result + c) % MOD;
        }
        return (int) result;
    }
}