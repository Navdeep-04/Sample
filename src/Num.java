import java.util.Scanner;

class Sorting {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int arr[] = new int[n];
//        for(int i = 0; i < n; i++)
//        {
//            arr[i] = sc.nextInt();
//        }
        int arr[] = {4,3,5,6,7,2};
        for (int i = 0; i < arr.length; i++)
        {
            int max = 0;
            for (int j = 0; j < arr.length; j++)
            {
                if (arr[j] > arr[i]) {
                    if (max == 0 || arr[j] < max) {
                        max = arr[j];
                    }
                }
            }
            System.out.println(arr[i] + "->" + max);
        }
    }
}