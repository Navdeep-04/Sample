import java.util.ArrayList;
import java.util.Arrays;

//cylic sort
public class DisappearedNumInArr {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        ArrayList<Integer> arr = new ArrayList<>();

        int i = 0;
        while(i < nums.length)
        {
            int correct = nums[i]-1;
            if(nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else{
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        for(int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1) {
                arr.add(j+1);
            }
        }
        System.out.println(arr);
    }
}
