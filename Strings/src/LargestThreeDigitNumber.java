public class LargestThreeDigitNumber {
    public String largestGoodInteger(String num) {
        String[] candidates = {"999", "888", "777", "666", "555", "444", "333", "222", "111", "000"};

        for (String candidate : candidates) {
            if (num.contains(candidate)) {
                return candidate;
            }
        }
        return "";
    }
}
