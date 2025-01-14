import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonArray {
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        int count = 0;
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) {
                count++;
            } else {
                if (setB.contains(A[i])) {
                    count++;
                }
                if (setA.contains(B[i])) {
                    count++;
                }
            }
            setA.add(A[i]);
            setB.add(B[i]);
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4};
        int[] B = {3, 1, 2, 4};
        System.out.println(Arrays.toString(findThePrefixCommonArray(A, B)));
    }
}