import java.util.Arrays;

public class PermutationString {
    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();

        if(length1 > length2){
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i = 0; i < length1; i++){
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(count1, count2)){
            return true;
        }

        for(int i = length1; i < length2; i++){
            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i - length1) - 'a']--;

            if(Arrays.equals(count1, count2)){
                return true;
            }
        }
        return false;
    }
}
