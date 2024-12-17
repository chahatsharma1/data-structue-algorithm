public class IntegerToHexadecimal {
    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder hex = new StringBuilder();

        while (num != 0) {
            int digit = num & 0xF;
            hex.append(hexChars[digit]);
            num >>>= 4;
        }

        return hex.reverse().toString();
    }
}
