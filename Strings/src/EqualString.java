import java.util.ArrayList;
import java.util.List;

public class EqualString {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                list.add(i);
            }
        }
        if (list.isEmpty()){
            return true;
        }

        if (list.size() == 2){
            int i = list.get(0);
            int j = list.get(1);
            return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
        }
        return false;
    }
}
