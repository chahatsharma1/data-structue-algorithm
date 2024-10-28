public class FirstOccurrence {
    public int findMatching(String text, String pat) {
        int m = text.length();
        int n  = pat.length();
        
        if (n > m){
            return -1;
        }

        for (int i = 0; i <= m - n ; i++) {
            int j = 0;

            while (j < n && text.charAt(i + j) == pat.charAt(j)){
                j++;
            }

            if (j == n){
                return i;
            }
        }
        return - 1;
    }
}
