import java.util.Arrays;

public class ArrayRotationLeft {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int  k = 2;
        int n = arr.length - 1;
        for(int i = 0; i < k ;i++)
        {
            int temp = arr[0];
            for(int j = 0; j < arr.length - 1; j++)
            {
                arr[j] = arr[j+1];
            }
            arr[n] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}

