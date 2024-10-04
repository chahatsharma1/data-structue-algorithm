import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0){
            return nums;
        }
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1){
                if (!deque.isEmpty()){
                ans[index++] = nums[deque.peek()];
                }
            }
        }
        return ans;
    }
}