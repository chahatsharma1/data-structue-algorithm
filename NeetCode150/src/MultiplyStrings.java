public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0 ; i--) {
            for (int j = n - 1; j >= 0 ; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int position1 = i + j;
                int position2 = i + j + 1;

                int sum = product + result[position2];

                result[position2] = sum % 10;
                result[position1] += sum/10;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int num : result){
            if (!(ans.isEmpty() && num == 0)){
                ans.append(num);
            }
        }
        return ans.isEmpty() ? "0" : ans.toString();
    }
}