import java.util.Arrays;

class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right){
            int mid = left + (right - left) / 2;
            if (canEat(piles, h, mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canEat(int[] piles, int h, int k){
        long currentHours = 0;
        for (int pile : piles) {
            currentHours += (pile + k -1) / k;
        }
        return currentHours <= h;
    }
}