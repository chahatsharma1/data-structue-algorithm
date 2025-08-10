import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReorderPowerOfTwo {
    public boolean reorderedPowerOf2(int n) {
        String target = sortDigits(n);
        Set<String> powerSet = new HashSet<>();
        
        for (int i = 1; i > 0; i <<= 1) {
            powerSet.add(sortDigits(i));
        }
        
        return powerSet.contains(target);
    }
    
    private String sortDigits(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}