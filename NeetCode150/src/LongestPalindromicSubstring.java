public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()){
            return "";
        }
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++){
            int firstCase = expandFromIndex(s, i, i);
            int secondCase = expandFromIndex(s, i, i + 1);
            int longest = Math.max(firstCase, secondCase);
            if (longest > end - start){
                start = i - ((longest - 1) / 2);
                end = i + (longest / 2);
            }
        }
        return s.substring(start, end + 1);
    }
    private static int expandFromIndex(String s, int left, int right){
        if(s == null || left > right){
            return 0;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}