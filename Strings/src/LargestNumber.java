import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums){
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (a, b) -> (b + a).compareTo(a + b));

        if (strings[0].equals("0")){
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings){
            stringBuilder.append(str);
        }

        return stringBuilder.toString();
    }
}
