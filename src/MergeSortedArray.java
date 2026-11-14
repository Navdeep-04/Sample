import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,5,6};
        ArrayList<Integer> arr = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        for(int i = 0; i < m+n; i++)
        {
            if(i < m && nums1[i] != 0){
                arr.add(nums1[i]);
            }
            if(i > m-1 && nums2[i-m] != 0){
                arr.add(nums2[i-m]);
            }
        }
        Collections.sort(arr);
        System.out.println(arr);
    }
}
