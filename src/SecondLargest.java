public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {10,5,8,20,2,18};
        int max = arr[0];
        int max2 = 0;
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max2 = max;
                max = arr[i];
            }
            if (arr[i] > max2 && arr[i] < max) {
                max2 = arr[i];
            }
        }
        System.out.println(max+" "+max2);
    }
}
