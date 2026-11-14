public class SecondSmallest {
    public static void main(String[] args) {
        int[] arr = {10,8,2,20,2,18};
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++)
            {
            if(arr[i] < min1)
            {
                min2 = min1;
                min1 = arr[i];
            }
            if(arr[i] < min2 && arr[i] != min1)
            {
                min2 = arr[i];
            }
        }
        System.out.println(min2+" "+min1);
    }
}
