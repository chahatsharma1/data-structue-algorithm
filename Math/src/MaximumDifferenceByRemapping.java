public class MaximumDifferenceByRemapping {
    public int minMaxDifference(int num) {
        String number = String.valueOf(num);

        char toReplaceMax = ' ';
        for(char ch : number.toCharArray()){
            if (ch != '9'){
                toReplaceMax = ch;
                break;
            }
        }

        String max = (toReplaceMax == ' ') ? number : number.replace(toReplaceMax, '9');
        int maxValue = Integer.parseInt(max);

        char toReplaceMin = number.charAt(0);
        String min = number.replace(toReplaceMin, '0');
        int minValue = Integer.parseInt(min);

        return maxValue- minValue;
    }
}
