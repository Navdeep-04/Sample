import java.util.ArrayList;
import java.util.Arrays;

public class Flames2 {
    public static void main(String[] args) {
        String str1 = "ajith";
        String str2 = "vijay";
        char[] str3 = {'F','L','A','M','E','S'};
        ArrayList<Integer> arr = new ArrayList<>();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0; i < str1.length()+str2.length(); i++)
        {
            if(i < str1.length()) {
                freq1[str1.charAt(i) - 'a']++;
            }
            if(i < str2.length()) {
                freq2[str2.charAt(i) - 'a']++;
            }
        }
        for(int i = 0; i < 26; i++){
            arr.add(Math.abs(freq1[i] - freq2[i]));
        }
        int count = 0;
        for(int i = 0; i < arr.size(); i++){
            count += arr.get(i);
        }
        char last =' ';
        int cnt = 0;
        int j=0;
        for(int i = 0; i < count*6; i++)
        {
            if(str3[j%6] != '!')
            {
                cnt++;
                if (cnt == count) {
                    last = str3[j%6];
                    str3[j%6] = '!';
                    cnt = 0;
                }
            }
            else i--;
            j++;
        }
        switch (last) {
            case 'F':
                System.out.println("Friends");
                break;
            case 'L':
                System.out.println("Love");
                break;
            case 'A':
                System.out.println("Affection");
                break;
            case 'M':
                System.out.println("Marriage");
                break;
            case 'E':
                System.out.println("Enemy");
                break;
            case 'S':
                System.out.println("Soulmate");
                break;
            default:
                System.out.println("Invalid");
        }
    }
}
