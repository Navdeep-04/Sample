import java.util.Scanner;

public class VowelsCons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str2 = str.toLowerCase();
        int vcount = 0;
        int ccount = 0;
        int scount = 0;
        for(int i = 0; i < str2.length(); i++)
        {
            char ch = str2.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                vcount++;
            }
            else if(ch == ' ')
            {
                scount++;
            }
            else {
                ccount++;
            }
        }
        System.out.println("Vowels : "+vcount+"\nConsonant : "+ccount+"\nSpace : "+scount);
    }
}
