import java.util.Scanner;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int ans = 0;
        String str = "XVII";
        boolean check = true;
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == 'I' || str.charAt(i) == 'V' || str.charAt(i) == 'X' || str.charAt(i) == 'L'
                    || str.charAt(i) == 'C' || str.charAt(i) == 'D' || str.charAt(i) == 'M')
            {
                check = true;
            }
            else
            {
                check = false;
                break;
            }
        }
        if(check == false)
        {
            System.out.println("Invalid");
        }
        else{
            //System.out.println("valid");
            for(int i = str.length() - 1; i >= 0; i--)
            {
                char ch = str.charAt(i);
                switch (ch)
                {
                    case 'I':
                        n = 1;
                        break;
                    case 'X':
                        n = 10;
                        break;
                    case 'V':
                        n = 5;
                        break;
                    case 'L':
                        n = 50;
                        break;
                    case 'C':
                        n = 100;
                        break;
                    case 'D':
                        n = 500;
                        break;
                    case 'M':
                        n = 1000;
                        break;
                }
                if(4 * n < ans)                                       //XVII
                {
                    ans = ans - n;
                }
                else
                {
                    ans = ans + n;
                }
            }
            System.out.print(ans);
        }
    }
}

