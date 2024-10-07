class StringToInt {
    public int myInt(String s) {
        s = s.trim();
        if (s.isEmpty()){
            return 0;
        }

        int sign = 1;
        int index = 0;
        if (s.charAt(index) == '-' || s.charAt(index) == '+'){
            sign = (s.charAt(index) == '-' ? - 1 : 1);
            index++;
        }

        int ans = 0;
        while (index < s.length()){
            char ch = s.charAt(index);
            if (!Character.isDigit(ch)){
                break;
            }

            int digit = ch - '0';

            if (ans > (Integer.MAX_VALUE - digit) / 10){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
            index++;
        }
        return ans * sign;
    }
}