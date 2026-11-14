import java.util.Arrays;
public class SortArrayAscDesc {
    public static void main(String[] args) {
        int[] arr = {9, 4, 3, 2, 7, 8, 5};
        for (int i = 0; i < arr.length; i++) {
            boolean check1 = false;
            boolean check2 = false;
            for (int j = 0; j < arr.length - 2; j++) {
                if (j % 2 == 0) {
                    if (arr[j] > arr[j + 2]) {
                        Swapped(arr, j, j+2);
                        check1 = true;
                    }
                } else {
                    if (arr[j] < arr[j + 2]) {
                        Swapped(arr, j, j+2);
                        check1 = true;
                    }
                }
            }
            if(check1 == false && check2 == false)
            {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void Swapped(int[] arr, int a, int b)
    {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
    }
}
