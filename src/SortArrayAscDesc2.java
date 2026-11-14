import java.util.Arrays;

public class SortArrayAscDesc2 {
    public static void main(String[] args) {
        int[] arr = {9, 4, 3, 1, 7, 8, 5, 6, 2};
        for(int i = 0; i < arr.length; i++)
        {
            int minIndex = i;
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] % 2 != 0 && arr[minIndex] % 2 != 0) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                if(arr[j] % 2 == 0 && arr[maxIndex] % 2 == 0)
                {
                    if (arr[j] > arr[maxIndex]) {
                        maxIndex = j;
                    }
                }
            }
            Sort(arr,minIndex,i);
            Sort(arr,maxIndex,i);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void Sort(int[] trr,int a, int b)
    {
        int temp = trr[a];
        trr[a] = trr[b];
        trr[b] = temp;
    }
}
