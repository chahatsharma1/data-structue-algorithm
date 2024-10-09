public class MinimumChar {
    public static int minChar(String str) {
        int i = 0;
        int j = str.length() - 1;
        int trim = j;
        int ans = 0;

        while (i < j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }
            else {
                ans++;
                i = 0;
                j = --trim;
            }
        }
        return ans;
    }
}
