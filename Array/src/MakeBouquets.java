public class MakeBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > bloomDay.length) {
            return -1;
        }


        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int days: bloomDay){
            low = Math.min(low, days);
            high = Math.max(high, days);
        }
        while (low < high){
            int mid = low + (high - low) / 2;
            if (canMake(bloomDay, m, k, mid)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int currentDay) {
        int bouquets = 0;
        int flowers = 0;

        for (int days : bloomDay){
            if (days <= currentDay){
                flowers++;
                if (flowers == k){
                    bouquets++;
                    flowers = 0;
                }
            }else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
