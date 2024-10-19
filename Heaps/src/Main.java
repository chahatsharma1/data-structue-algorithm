import java.util.*;

public class Main {
    public static List<Integer> maxCombinations(int N, int K, int[] A, int[] B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = N -1; i > N - K - 1 ; i--) {
            for (int j = N; j > N - K - 1; j--) {
                int sum = A[i] + B[j];
                if (pq.size() < K) {
                    pq.add(sum);
                }
                else {
                    if (pq.peek() < sum){
                        pq.remove();
                        pq.add(sum);

                    }
                    else break;
                }
            }
        }
        while (pq.size() > 0) {
            list.add(0, pq.poll());
        }
        return list;
    }
}