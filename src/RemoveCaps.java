public class RemoveCaps {
    public static void main(String[] args) {
        String str = "Welcome to Java Training";
        String str2 = "";
        String str3 = "";
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
            {
                str2 += str.charAt(i);
            }
            else {
                str3 += str.charAt(i);
            }
        }
        System.out.println(str3+" "+str2);
    }
}
