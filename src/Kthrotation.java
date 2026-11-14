import java.util.*;
public class Kthrotation {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5};
        int k=2;
        int l=k;
        int n = arr.length;
        int[] arr1 = new int[n];
        for (int i = 0; i < arr.length; i++) {
            if(i < l) {
                arr1[i] = arr[n - k];
                k--;
            }
            else {
                arr1[i] = arr[i - l];
            }
        }
        System.out.println(Arrays.toString(arr1));
    }
}
