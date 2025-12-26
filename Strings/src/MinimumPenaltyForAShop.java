public class MinimumPenaltyForAShop {
    public int bestClosingTime(String customers) {
        int penalty = 0;
        int n = customers.length();

        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int bestHour = 0;

        for (int hour = 0; hour < n; hour++) {
            if (customers.charAt(hour) == 'Y') {
                penalty--;  
            } else {
                penalty++;  
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = hour + 1;
            }
        }
        return bestHour;
    }
}