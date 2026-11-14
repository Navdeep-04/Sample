import java.util.Arrays;
import java.util.HashMap;

public class FrequencyOfElements {
    public static void main(String[] args) {
        int[] arr = {10, 30, 10, 20, 10, 20, 30, 10};
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 1; i < n; i++)
        {
            int cnt = 1;
            while(i < n && arr[i] == arr[i-1]) {
                cnt++;
                i++;
            }
            System.out.println(arr[i-1]+" : "+cnt);
        }
    }
}
