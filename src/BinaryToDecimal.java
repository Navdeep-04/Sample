import java.util.Scanner;

public class BinaryToDecimal {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String binary = sc.next();
            int num = 0;
            for(int i = 0; i < binary.length(); i++)
            {
                char ch = binary.charAt(binary.length() - 1 - i);
                if(ch == '1')
                {
                    num += Math.pow(2 , i);
                }
            }
            System.out.println(num);
            int a = 10;
            System.out.println(Integer.toBinaryString(a));
            String bin = Integer.toString(a);
            System.out.println(Integer.parseInt(bin, 2));
        }
    }


