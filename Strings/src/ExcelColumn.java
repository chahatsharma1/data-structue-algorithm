public class ExcelColumn {
    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            int value = ch - 'A' + 1; // Calculate the position of the character
            result = result * 26 + value; // Base-26 conversion
        }
        return result;
    }
}