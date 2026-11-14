import java.util.Arrays;

public class RunningSum1Darr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int sum = 0;
        int[] srr = new int[arr.length];
        srr[0]=arr[0];
        for(int i = 1; i < arr.length; i++)
        {
            srr[i] = arr[i] + srr[i-1];
        }
        System.out.println(Arrays.toString(srr));
    }
}
