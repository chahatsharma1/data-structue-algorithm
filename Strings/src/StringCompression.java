public class StringCompression {
    public int compress(char[] chars) {
        int newLength = 0;
        int read = 0;

        while (read < chars.length){
            char current = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == current){
                read++;
                count++;
            }
            chars[newLength++] = current;

            if (count > 1){
                for (char ch : String.valueOf(count).toCharArray()){
                    chars[newLength++] = ch;
                }
            }
        }
        return newLength;
    }
}
