public class NeighboringBitwiseXOR {
    public boolean doesValidArrayExist(int[] derived){
        return isValid(derived, 0) || isValid(derived, 1);
    }

    private boolean isValid(int[] derived, int value){
        int n = derived.length;
        int[] original = new int[n];
        original[0] = value;

        for (int i = 0; i < n - 1; i++){
            original[i + 1] = derived[i] ^ original[i];
            if (original[i + 1] < 0 || original[i + 1] > 1){
                return false;
            }
        }
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }
}
