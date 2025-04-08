import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MakeArrayDistinct {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums){
            list.add(num);
        }

        while (true){
            Set<Integer> set = new HashSet<>();
            boolean hasDuplicates = false;

            for (int num : list){
                if (set.contains(num)){
                    hasDuplicates = true;
                    break;
                }
                set.add(num);
            }

            if (!hasDuplicates){
                break;
            }
            int count = Math.min(3, list.size());
            for (int i = 0; i < count; i++){
                list.removeFirst();
            }
            ans++;
        }
        return ans;
    }
}
