import java.util.Scanner;

class StringEmail {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String input = sc.nextLine();
        int dotIndex = input.indexOf(".");
        if (dotIndex != 0)
        {
            String afterDot = input.substring(dotIndex + 1);

            int c = 0;
            String arr[] = {"com", "org", "biz"};
            for (int i = 0; i < arr.length; i++)
            {
                if (input.contains("@"))
                {
                    if (afterDot.equals(arr[i]))
                    {
                        c++;
                        System.out.println("Valid Email : "+input);
                    }
                }
            }
            if (c == 0)
            {
                System.out.println("invalid");
            }
        }
    }
}