import java.util.ArrayList;
import java.util.List;

public class TestJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < words.length){
            int j = i;
            int lineLength = 0;

            while (j < words.length && lineLength + words[j].length() + (j - i) <= maxWidth){
                lineLength += words[j].length();
                j++;
            }

            int wordCount = j - i;
            int spaceNeeded = maxWidth - lineLength;
            StringBuilder currentLine = new StringBuilder();

            if (j == words.length || wordCount == 1){
                for (int k = i; k < j; k++){
                    if (k > i){
                        currentLine.append(" ");
                    }
                    currentLine.append(words[k]);
                }
                while (currentLine.length() < maxWidth){
                    currentLine.append(" ");
                }
            } else {

                int spaceBetween = spaceNeeded / (wordCount - 1);
                int extraSpace = spaceNeeded % (wordCount - 1);

                for (int k = i; k < j; k++){
                    currentLine.append(words[k]);
                    if (k < j - 1){
                        int space = spaceBetween + (extraSpace-- > 0 ? 1 : 0);
                        currentLine.append(" ".repeat(Math.max(0, space)));
                    }
                }
            }
            ans.add(currentLine.toString());
            i = j;
        }
        return ans;
    }
}
