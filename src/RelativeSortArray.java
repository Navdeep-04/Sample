import java.util.Arrays;

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] arr = new int[arr1.length];
        int k = 0;
        int l = 0;
        for(int i = 0; i < arr1.length && k < arr1.length; i++)
        {
            for (int j = 0; j < arr1.length; j++)
            {
                if(i < arr2.length) {
                    if (arr2[i] == arr1[j]) {
                        arr[k] = arr1[j];
                        k++;
                    }
                }
//                else{
//                    if(i < arr1.length) {
//                        arr[k] = arr1[j];
//                        k++;
//                    }
//                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
