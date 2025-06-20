import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0){
            return new int[0];
        }

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            if(!deque.isEmpty() && deque.peekFirst() <= i - k){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }

            deque.offer(i);

            if(i >= k - 1){
                if (!deque.isEmpty()){
                    ans[i - k + 1] = nums[deque.peekFirst()];
                }
            }
        }
        return ans;
    }
}
