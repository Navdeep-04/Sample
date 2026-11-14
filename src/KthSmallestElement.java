import java.util.Arrays;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 4, 2, 5, 6, 3, 3, 4};
        int k = 4;
        int n = arr.length;
        int cnt = 0;
        int result = 0;
        Arrays.sort(arr);
//      System.out.println(Arrays.toString(arr));
        for(int i = 1; i < n; i++)
        {
            while(i < n-1 && arr[i] == arr[i-1])
            {
                i++;
            }
            cnt++;
            if(cnt == k)
            {
                result = arr[i];
                break;
            }
        }
        System.out.println(result);
    }
}
