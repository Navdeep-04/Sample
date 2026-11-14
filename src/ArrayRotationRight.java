import java.util.Arrays;

public class ArrayRotationRight {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 1;
        int n = arr.length-1;
        for(int i = 0;i < k; i++)
        {
            int temp  = arr[n];
            for(int j = arr.length-1; j > 0; j--)
            {
                arr[j] = arr[j-1];
            }
            arr[0] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
