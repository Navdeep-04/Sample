import java.util.Scanner;

public class Harshad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n;
        int rem = 0;
        while(n!=0)
        {
            int digit = n % 10;
            rem += digit;
            n /= 10;
        }
        if(temp % rem == 0)
        {
            System.out.println("Harshad Number");
        }
        else {
            System.out.println("Not harshad Number");
        }
    }
}
