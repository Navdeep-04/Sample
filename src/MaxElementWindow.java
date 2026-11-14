public class MaxElementWindow {
    public static void main(String[] args) {
        int[] arr = {3,1,-3,5,4,6,2,8};
        int k = 3;
        int n = arr.length;
        for(int i = 0; i <= n - k; i++)
        {
            int max = 0;
            for (int j = i; j < k + i; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            System.out.print(max + " ");
        }
    }
}
