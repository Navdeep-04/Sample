import java.util.Arrays;
import java.util.HashSet;

public class AAADemo {
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        int[] arr = new int[gain.length + 1];
        int num = 0;
        for(int i = 0; i <= gain.length; i++)
        {
            if(i > 0)
            {
                arr[i] = gain[i - 1] + num;
                num = arr[i];
            }
        }
        int max  = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
