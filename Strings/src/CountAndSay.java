public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }

        String string = countAndSay(n - 1);
        StringBuilder ans = new StringBuilder();

        int count = 1;

        for (int i = 1; i < string.length(); i++){
            if (string.charAt(i) == string.charAt(i - 1)){
                count++;
            } else {
                ans.append(count).append(string.charAt(i - 1));
                count = 1;
            }
        }
        ans.append(count).append(string.charAt(string.length() - 1));
        return ans.toString();
    }
}
