public class TwoIntegerSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while(i < j){
            int num = numbers[i] + numbers[j];
            if(num == target){
                return new int[]{i + 1, j + 1};
            }
            if(num > target){
                j--;
            } else{
                i++;
            }
        }
        return new int[]{0, 0};
    }
}
