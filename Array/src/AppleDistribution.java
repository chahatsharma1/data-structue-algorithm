import java.util.Arrays;

public class AppleDistribution {
    public int minBoxes(int[] apple, int[] capacity){
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }

        Arrays.sort(capacity);
        
        int currentCapacity = 0;
        int boxesUsed = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            currentCapacity += capacity[i];
            boxesUsed++;

            if (currentCapacity >= totalApples) {
                return boxesUsed;
            }
        }
        return -1;
    }
}