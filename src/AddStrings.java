public class AddStrings
{
    public static void main(String[] args)
    {
        String num1 = "11";
        String num2 = "123";
        int n1 = toInt(num1);
        int n2 = toInt(num2);
        System.out.println(n1+n2);
    }
    public static int toInt(String str)
    {
        int sum = 0;
        for (int i = 0; i < str.length(); i++)
        {
            int digit = str.charAt(i) - '0';
            sum = sum * 10 + digit;
        }
        return sum;
    }
}
