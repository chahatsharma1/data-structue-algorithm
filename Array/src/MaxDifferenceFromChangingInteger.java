public class MaxDifferenceFromChangingInteger {
    public int maxDiff(int num) {
        String number = String.valueOf(num);

        char replaceMax = ' ';
        for(char ch : number.toCharArray()){
            if (ch != '9'){
                replaceMax = ch;
                break;
            }
        }

        String maxString = number;
        if (replaceMax != ' '){
            maxString = maxString.replace(replaceMax, '9');
        }

        char replaceMin = ' ';
        char firstElement = number.charAt(0);

        if(firstElement != '1'){
            replaceMin = firstElement;
            number = number.replace(replaceMin, '1');
        } else{
            for (int i = 1; i < number.length(); i++) {
                if (number.charAt(i) != '0' && number.charAt(i) != '1'){
                    replaceMin = number.charAt(i);
                    break;
                }
            }
            if (replaceMin != ' '){
                number = number.charAt(0) + number.substring(1).replace(replaceMin, '0');
            }
        }
        int max = Integer.parseInt(maxString);
        int min = Integer.parseInt(number);

        return max - min;
    }
}
