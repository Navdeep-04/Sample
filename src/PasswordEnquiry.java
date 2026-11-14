public class PasswordEnquiry {
    public static void main(String[] args) {
        String pwd = "Hello@123";
        int count = 0;
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean special = false;
        boolean brace = true;
        if(pwd.length() > 5)
        {
            for(int i = 0; i < pwd.length(); i++)
            {
                char ch = pwd.charAt(i);
                if((ch >= 'A' && ch <= 'Z'))
                {
                    upper = true;
                }
                else if(ch >= 'a' && ch <= 'z')
                {
                    lower = true;
                }
                else if(ch >= '0' && ch <= '9')
                {
                    digit = true;
                }
                else if(ch == '{' || ch == '}' || ch == '[' || ch == ']' || ch == '(' || ch == ')')
                {
                    brace = false;
                }
                else
                {
                    special = true;
                }
            }
        }
        else {
            System.out.println("Invalid. Enter more than 5 length.");
        }
        if(upper && lower && digit && special && brace)
        {
            System.out.println("Valid Passward");
        }
        else{
            System.out.println("invalid");
        }
    }
}
