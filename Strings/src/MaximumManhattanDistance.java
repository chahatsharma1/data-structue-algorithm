public class MaximumManhattanDistance {
    public int maxDistance(String s, int k) {
        return Math.max(Math.max(flip(s, k, "NE"), flip(s, k, "NW")),
                Math.max(flip(s, k, "SE"), flip(s, k, "SW")));
    }

    private int flip(String s, int k, String direction){
        int ans = 0;
        int move = 0;
        int opposite = 0;

        for (char ch : s.toCharArray()){
            if (direction.indexOf(ch) >= 0){
                move++;
            } else {
                opposite++;
                move--;
            }
            int ansWithFlips = move + 2 * Math.min(k, opposite);
            ans = Math.max(ans, ansWithFlips);
        }
        return ans;
    }
}
