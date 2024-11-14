import java.util.ArrayList;
import java.util.HashMap;

public class DistinctNumbers {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();

        if (B > n){
            return ans;
        }

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < B; i++) {
            freqMap.put(A.get(i), freqMap.getOrDefault(A.get(i), 0) + 1);
            if (freqMap.get(A.get(i)) == 1){
                count++;
            }
        }
        ans.add(count);

        for (int j = B; j < n; j++){
            int leftElement = A.get(j - B);
            if (freqMap.get(leftElement) == 1){
                count--;
            }
            freqMap.put(leftElement, freqMap.get(leftElement) - 1);
            if (freqMap.get(leftElement) == 0){
                freqMap.remove(leftElement);
            }

            int rightElement = A.get(j);
            freqMap.put(rightElement, freqMap.getOrDefault(rightElement, 0) + 1);
            if (freqMap.get(rightElement) == 1){
                count++;
            }
            ans.add(count);
        }
        return ans;
    }
}