import java.util.Arrays;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        String[] strings = new String[numRows];
        Arrays.fill(strings, "");

        int i = 0;
        while (i < s.length()){
            for (int row = 0; row < numRows && i < s.length(); row++){
                strings[row] += s.charAt(i++);
            }
            for (int cross = numRows - 2; cross > 0 && i < s.length(); cross--){
                strings[cross] += s.charAt(i++);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String res : strings){
            ans.append(res);
        }
        return ans.toString();
    }
}
