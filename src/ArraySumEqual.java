import java.util.Scanner;

public class ArraySumEqual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int result = 0;
        a:
        for(int i = 0 ; i < n-1; i++) {
            b:
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i]+arr[j];
                if (sum == target) {
                    System.out.println("Array has Two Sum "+arr[i]+" and "+arr[j]+" for : "+sum);
                    result = 1;
                    break a;
                }
            }
        }
        if(result == 0) {
            System.out.println("No Two Sum");
        }
    }
}
