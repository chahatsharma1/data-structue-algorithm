import java.util.*;

public class UniqueEvenThreeDigitNumbers {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        List<Integer> result = new ArrayList<>();

        for (int num = 100; num <= 999; num += 2) {
            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            int[] count = new int[10];
            count[a]++;
            count[b]++;
            count[c]++;

            boolean canForm = true;
            for (int i = 0; i < 10; i++) {
                if (count[i] > freq[i]) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) {
                result.add(num);
            }
        }

        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }

        return resArray;
    }
}
