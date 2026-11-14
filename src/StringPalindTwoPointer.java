import java.util.Scanner;

public class StringPalindTwoPointer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int start = 0;
        int end = str.length() - 1;
        int c = 0;
        while(start <= end) //for(int i = 0; j = str.length()-1; i <= j; i++ ; j--)
        {
            if(str.charAt(start) != str.charAt(end))
            {
                c++;
                break;
            }
            start++;
            end--;
        }
        if(c == 0)
        {
            System.out.println("palindrome ");
        }
        else {
            System.out.println("not palindrome");
        }
    }
}
