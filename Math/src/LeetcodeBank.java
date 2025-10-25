public class LeetcodeBank {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;

        return (7 * weeks * (weeks + 7)) / 2 + (days * (2 * (weeks + 1) + (days - 1))) / 2;
    }
}