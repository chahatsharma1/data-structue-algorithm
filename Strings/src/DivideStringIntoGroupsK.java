public class DivideStringIntoGroupsK {
    public static String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int groups = (n + k - 1) / k;
        String[] ans = new String[groups];
        int i = 0;
        int j = 0;

        while (i < s.length()){
            int end = Math.min(i + k, s.length());
            String word = s.substring(i, end);

            if (word.length() < k){
                StringBuilder sb = new StringBuilder(word);
                while (sb.length() < k){
                    sb.append(fill);
                }
                word = sb.toString();
            }
            ans[j++] = word;
            i += k;
        }
        return ans;
    }
}