public class MaxConsecutiveOne {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        int cnt = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++)
        {

            if(nums[i] == 1) {
                cnt++;
                if (cnt > max) {
                    max = cnt;
                }
            }
            else{
                cnt = 0;
            }
        }
        System.out.println(max);
    }
}
