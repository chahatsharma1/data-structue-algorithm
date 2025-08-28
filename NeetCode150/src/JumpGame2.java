public class JumpGame2 {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int max = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            
            if (i == currentEnd) {
                jumps++;
                currentEnd = max;
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }
}