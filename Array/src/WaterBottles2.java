public class WaterBottles2 {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int result = 0;
        int empty = 0;

        int full = numBottles;

        while (full > 0) {
            result += full;
            empty += full;
            full = 0;

            if (empty >= numExchange) {
                empty -= numExchange;
                full += 1;
                numExchange++;
            }
        }
        return result;
    }
}