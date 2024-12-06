import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        answer.add(firstRow);

        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> prevRow = answer.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            currentRow.add(1);

            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currentRow.add(1);
            if (i == rowIndex) {
                result = currentRow;
            }
            answer.add(currentRow);
        }
        return result;
    }
}