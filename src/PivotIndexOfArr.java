public class PivotIndexOfArr {
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        int total = 0;
        int leftsum = 0;
        for(int a : arr)
        {
            total += a;
        }
        System.out.println(total);
        for (int i = 0; i < arr.length; i++)
        {
            if(leftsum == total - arr[i] - leftsum)
            {
                System.out.println(i);
                break;
            }
            leftsum += arr[i];
        }
    }
}
