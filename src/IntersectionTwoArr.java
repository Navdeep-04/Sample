import java.util.ArrayList;

public class IntersectionTwoArr {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        ArrayList<Integer> arr = new ArrayList<>();
        for(int  i = 0; i < nums1.length; i++)
        {
            for(int j = 0; j < nums2.length; j++)
            {
                if(nums1[i] == nums2[j] && !arr.contains(nums1[i]))
                {
                    arr.add(nums1[i]);
                    break;
                }
            }
        }
        System.out.println(arr);
    }
}
