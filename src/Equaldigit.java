
public class Equaldigit {
    public static void main(String[] args) {
        int arr[] = {44,464,6789,7657};
        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
            int digcount = 0;
            int temp = arr[i];
            while(temp != 0)
            {

                temp /= 10;
                digcount++;
            }
            int base = (int) Math.pow(10,digcount-1);
            if(arr[i] % 10 == arr[i] / base )
            {
                count++;
                System.out.println("Same : "+arr[i]);
            }
            else{
                System.out.println("Different : "+arr[i]);
            }
        }
        System.out.print(count);
    }
}
