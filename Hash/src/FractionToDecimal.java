import java.util.*;

public class FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);

        result.append(dividend / divisor);
        long remainder = dividend % divisor;

        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        Map<Long, Integer> remainderMap = new HashMap<>();

        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                int index = remainderMap.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }

            remainderMap.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / divisor);
            remainder %= divisor;
        }

        return result.toString();
    }
}
