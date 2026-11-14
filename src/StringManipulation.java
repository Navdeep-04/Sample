import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder str2 = new StringBuilder(str);
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == 'A')
            {
                str2.setCharAt(i,'B');
            }
            if(str.charAt(i) == 'a')
            {
                str2.setCharAt(i, '@');
            }
            if(str.charAt(i) == '1')
            {
                str2.setCharAt(i,'2');
            }
        }
        System.out.println("Modified string : "+str2);
        System.out.println(str.replace('A','B').replace('a','@').replace('1','2'));
    }
}

//String str3 = "";
//for(int i = 0; i < str.length(); i++)
//        {
//            if(str.charAt(i) == 'A')
//        {
//            str3 += 'B';
//        }
//            else if(str.charAt(i) == 'a')
//        {
//            str3 += '@';
//        }
//            else
//        {
//            str3 += str.charAt(i);
//        }
//        }
