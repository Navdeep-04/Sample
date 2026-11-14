import java.util.Scanner;

public class OddWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.next();
        }
        int max = Integer.MIN_VALUE;
        String Large = " ";
        int c = 0;
        for (int i = 0; i < arr.length; i++)
        {
            String m = arr[i];
            int len = m.length();
            if (len % 2 != 0)
            {
                if (len > max)
                {
                    max = len;
                    Large = arr[i];
                    c++;
                }
            }
        }
        if (c > 0) {
            System.out.println(Large);
        }
        else {
            System.out.println("Better Luck Nexttime !");
        }
    }
}
