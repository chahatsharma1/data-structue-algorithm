import java.util.PriorityQueue;

public class FindScore {
    public long findScore(int[] nums) {
        boolean[] marked = new boolean[nums.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < nums.length; i++){
            pq.offer(new int[]{nums[i], i});
        }

        long score = 0;

        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int value = current[0];
            int index = current[1];

            if (marked[index]){
                continue;
            }

            score += value;
            marked[index] = true;

            if (index > 0){
                marked[index - 1] = true;
            }
            if (index < nums.length - 1){
                marked[index + 1] = true;
            }
        }
        return score;
    }
}
