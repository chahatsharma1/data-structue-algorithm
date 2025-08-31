public class MergeTriplets {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean xMatch = false;
        boolean yMatch = false;
        boolean zMatch = false;
        
        for (int[] t : triplets) {
            if (t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                if (t[0] == target[0]) {
                    xMatch = true;
                }
                if (t[1] == target[1]) {
                    yMatch = true;
                }
                if (t[2] == target[2]) {
                    zMatch = true;
                }
            }
        }
        
        return xMatch && yMatch && zMatch;
    }
}
