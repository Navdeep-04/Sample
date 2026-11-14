public class RedPenGreenPen {
    public static void main(String[] args) {
        int[] arr = {1,2,1,6,10,9};
        boolean check = false;
        int result = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] % 2 != 0)
            {
                check  = true;
            }
            else {
                if(check)
                {
                    result++;
                }
                check = false;
            }
        }
        System.out.println(result);
    }
}
