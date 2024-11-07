import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++){
            int paper = citations.length - i;
            if (citations[i] >= paper){
                return paper;
            }
        }
        return 0;
    }
}
