public class SortColors {
    public void sortColors(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int maxIndex = getMax(arr, last);
            swap(arr, last, maxIndex);
        }
    }

    static void swap(int[] arr, int last, int maxIndex) {
        int temp = arr[last];
        arr[last] = arr[maxIndex];
        arr[maxIndex] = temp;
    }

    static int getMax(int[] arr, int last) {
        int max  = 0;
        for (int i = 0; i <= last; i++) {
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }
}