import java.util.Arrays;

public class SpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;

        int[] ans = new int[spells.length];
        for (int i = 0; i < spells.length; i++){
            int spell = spells[i];
            long minPotion = (success + spell - 1)/ spell;

            int left = 0;
            int right = m - 1;
            while (left <= right){
                int mid = left + (right - left)/ 2;
                if (potions[mid] >= minPotion){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = m - left;
        }
        return ans;
    }
}
