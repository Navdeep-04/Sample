import java.util.Arrays;
public class NextGreaterIn2Arr {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};
        for(int i = 0; i < nums1.length; i++)
        {
            Boolean flag = true;
            for(int j = 0; j < nums2.length-1; j++)
            {
               a: if(nums2[j] == nums1[i])
                {
                    for(int k = j; k < nums2.length; k++)
                        if(nums2[k] > nums2[j])
                        {
                            nums1[i] = nums2[k];
                            flag = false;
                            break a;
                        }
                }
            }
            if(flag)
            {
                nums1[i] = -1;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}
