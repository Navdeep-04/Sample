import java.util.Arrays;

public class Flames {
    public static void main(String[] args) {
        String str1 = "kamal";
        String str2 = "rajini";
        char[] str3 = {'F','L','A','M','E','S'};
        int[] freq = new int[26];
        for(int i = 0; i < str1.length()+str2.length(); i++)
        {
            if(i < str1.length()) {
                freq[str1.charAt(i) - 'a']++;
            }
            if(i < str2.length()) {
                if(freq[str2.charAt(i) - 'a'] == 0) {
                    freq[str2.charAt(i) - 'a']++;
                }
                else{
                    freq[str2.charAt(i) - 'a']--;
                }
            }
        }
        System.out.println(Arrays.toString(freq));
        int count = 0;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] == 1 || freq[i]%2 !=0) {
                count += freq[i];
            }
        }
        System.out.println(count);
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
        System.out.println(last);
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
                System.out.println("Marrige");
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

//        for(int i = 0; i < count * str3.length; i++)
//        {
//            for(int k = 0; k < str3.length; k++){
//                if(str3[k] != '!')
//                {
//                    cnt++;
//                    if (cnt == count) {
//                        last = str3[k];
//                        str3[k] = '!';
//                        cnt = 0;
//                    }
//                }
//            }
//        }
//        System.out.println(last);
//        System.out.println(Arrays.toString(str3));
    }
}


