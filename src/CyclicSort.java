import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = {4,2,3,1,0};
        int i = 0;
        while(i < nums.length)
        {
            int correct = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[correct])
            {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else{
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
