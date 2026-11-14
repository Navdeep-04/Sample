public class UniqueNum {
    public static void main(String[] args) {
        int[] arr = {1,1,2};
        int sum = 0;
        for(int i = 0;i < arr.length; i++)
        {
            sum = sum ^ arr[i];
        }
        System.out.println(sum);
    }
}
