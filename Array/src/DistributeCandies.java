public class DistributeCandies {
    public long distributeCandies(int n, int limit) {
         int limitPlusOne = limit + 1;
         long oneChildExceedsLimit = ways(n - limitPlusOne);
         long twoChildrenExceedLimit = ways(n - 2 * limitPlusOne);
         long threeChildrenExceedLimit = ways(n - 3 * limitPlusOne);
         return ways(n) - 3 * oneChildExceedsLimit + 3 * twoChildrenExceedLimit - threeChildrenExceedLimit;
    }
    private long ways(int n) {
        if (n < 0) {
            return 0;
        }
        return nCk(n + 2);
    }

    private long nCk(int n) {
         long res = 1;
         for (int i = 1; i <= 2; ++i) {
              res = res * (n - i + 1) / i;
         }
         return res;
    }
}