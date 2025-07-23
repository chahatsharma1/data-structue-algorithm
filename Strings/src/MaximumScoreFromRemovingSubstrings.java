public class MaximumScoreFromRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {
        if(x > y){
            return calculate(s, "ab", x, y);
        } else {
            return calculate(s, "ba", y, x);
        }
    }
    private int calculate(String s, String word, int high, int low){
        char ch1 = word.charAt(0);
        char ch2 = word.charAt(1);
        int score = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (char c : s.toCharArray()){
            if(!sb.isEmpty() && sb.charAt(sb.length() - 1) == ch1 && c == ch2){
                sb.deleteCharAt(sb.length() - 1);
                score += high;
            } else {
                sb.append(c);
            }
        }

        for (int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);
            if(!temp.isEmpty() && temp.charAt(temp.length() - 1) == ch2 && c == ch1){
                temp.deleteCharAt(temp.length() - 1);
                score += low;
            } else {
                temp.append(c);
            }
        }
        return score;
    }
}