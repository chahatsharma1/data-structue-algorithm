public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        int min = (b.length() + a.length() - 1) / a.length();

        StringBuilder stringBuilder = new StringBuilder(a.repeat(min));

        if (stringBuilder.toString().contains(b)){
            return min;
        }

        stringBuilder.append(a);
        if (stringBuilder.toString().contains(b)){
            return min + 1;
        }
        return -1;
    }
}
