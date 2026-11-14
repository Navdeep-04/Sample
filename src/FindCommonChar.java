import java.util.ArrayList;

public class FindCommonChar {
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        int[] freq = new int[26];
        int n = 0;
        while(n < words.length) {
            for (int i = 0; i < words[n].length(); i++) {
                    freq[words[n].charAt(i) - 'a']++;
            }
            n++;
        }
        ArrayList<String> str = new ArrayList<>();
        char ch = ' ';
        for (int i = 0; i < 26; i++) {
            if(freq[i] != 0) {
                if(freq[i] % 3 == 0)
                {
                   int z = freq[i] / 3;
                   ch = (char) (i + 'a');
                   for(int j = 0; j < z; j++) {
                       str.add(String.valueOf(ch));
                   }
                }
            }
        }
        System.out.println(str);
    }
}
