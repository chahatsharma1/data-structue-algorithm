public class MinOperationsToMoveBalls {
    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        int leftCount = 0;
        int leftCost = 0;
        for (int i = 0; i < n; i++) {
            answer[i] += leftCost;
            if (boxes.charAt(i) == '1') {
                leftCount++;
            }
            leftCost += leftCount;
        }

        int rightCount = 0;
        int rightCost = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += rightCost;
            if (boxes.charAt(i) == '1') {
                rightCount++;
            }
            rightCost += rightCount;
        }

        return answer;
    }
}
