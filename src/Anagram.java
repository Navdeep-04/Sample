public class Anagram {
    public static void main(String[] args) {
        String str = "silent";
        String str1 = "listen";
        int[] arr = new int[26];
        boolean result = true;
        for(int i = 0; i < str.length(); i++)
        {
            arr[str.charAt(i) - 'a']++;
            arr[str1.charAt(i) - 'a']--;
        }
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] != 0){
                result = false;
                break;
            }
        }
        if(result) {
            System.out.println("Anagram");
        }
        else{
            System.out.println("Not Anagram");
        }
    }
}
// if(str3[j%6] != '!')
//        {
//cnt++;
//        if (cnt == count) {
//last = str3[j%6];
//str3[j%6] = '!';
//cnt = 0;
//        }
//        }
//        else i--;
//j++;