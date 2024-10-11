public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int maxLength = Math.max(str1.length, str2.length);

        for (int i = 0; i < maxLength; i++) {
            int ver1 = (i < str1.length) ? Integer.parseInt(str1[i]) : 0;
            int ver2 = (i < str2.length) ? Integer.parseInt(str2[i]) : 0;

            if (ver1 < ver2){
                return -1;
            } else if (ver1 > ver2){
                return 1;
            }
        }
        return 0;
    }
}
