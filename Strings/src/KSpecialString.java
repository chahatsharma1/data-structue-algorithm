public class KSpecialString {
    public int minimumDeletions(String word, int k) {
        int ans = Integer.MAX_VALUE;
        int[] count = new int[26];

        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }

        for (int minFreq : count) {
            int deletions = 0;
            for (int freq : count) {
                if (freq < minFreq) {
                    deletions += freq;
                } else {
                    deletions += Math.max(0, freq - (minFreq + k));
                }
            }

            ans = Math.min(ans, deletions);
        }

        return ans;
    }
}