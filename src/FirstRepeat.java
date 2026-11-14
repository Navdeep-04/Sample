import java.util.Scanner;

public class FirstRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        int result = 0;
        for(int i = 0 ; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {

                    System.out.println(arr[i]);
                    result = 1;
                    break;
                }
            }
            if (result == 1)
                break;
        }
        if(result == 0) {
            System.out.println("No Repeat");
        }
    }
}
