public class StringTransformation {
    int MOD = 1_000_000_007;
    public int transformedLength(String s, int t) {
        long[] count = new long[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int step = 0; step < t; step++) {
            long[] newCount = new long[26];
            for (int i = 0; i < 26; i++) {
                if (i == 25) {
                    newCount[0] = (newCount[0] + count[25]) % MOD;
                    newCount[1] = (newCount[1] + count[25]) % MOD;
                } else {
                    newCount[i + 1] = (newCount[i + 1] + count[i]) % MOD;
                }
            }
            count = newCount;
        }

        long result = 0;
        for (long c : count) {
            result = (result + c) % MOD;
        }
        return (int) result;
    }
}
