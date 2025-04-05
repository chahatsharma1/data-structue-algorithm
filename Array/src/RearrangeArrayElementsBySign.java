import java.util.ArrayList;

public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num >= 0) pos.add(num);
            else neg.add(num);
        }

        int i = 0, p = 0, ng = 0;
        while (i < n) {
            result[i++] = pos.get(p++);
            result[i++] = neg.get(ng++);
        }
        return result;
    }
}