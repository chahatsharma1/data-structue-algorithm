import java.util.Arrays;

public class EatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right){
            int mid  = left + ((right - left) / 2);
            if(canEat(mid, piles, h)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean canEat(int k, int[] piles, int h){
        int hours = 0;
        for(int pile : piles){
            hours += (pile + k - 1)/k;
        }
        return hours <= h;
    }
}
