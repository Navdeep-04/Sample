import java.util.Arrays;

public class kthrotation2 {
    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        int n = nums.length-1;
        int start = 0;
        int end = n;
        int mid = n - k;
        swap(nums,start,end);
        System.out.println(Arrays.toString(nums));
        swap(nums,start,mid-1);
        swap(nums,mid,end);
        System.out.println(Arrays.toString(nums));
    }
    public static void swap(int[] ar,int a, int b)
    {
        while(a <= b)
        {
            int temp = ar[a];
            ar[a] = ar[b];
            ar[b] = temp;
            a++;
            b--;
        }
    }
}
