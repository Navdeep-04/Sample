public class NextGreater {
    public static void main(String[] args) {
        int[] arr = {4,5,2,10,8,6};
        boolean m= false;
        for(int i = 0; i < arr.length; i++)
        {                                                                                  //int max = -1;
            for(int j = i+1; j < arr.length; j++)
            {
                if(arr[i] < arr[j])
                {
                    System.out.print(arr[j]+" ");                                          //max = arr[j];
                    m = false;
                    break;
                }
                else {
                    m = true;
                }
            }
            if(m)
            {
                System.out.print(-1+" ");
            }                                                                                   //sout(max+" ");
        }
    }
}
