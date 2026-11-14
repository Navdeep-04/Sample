public class CompressString {
    public static void main(String[] args) {
        String str = "aabcccccaaa";
        String result = "";
        int cnt = 1;
        for(int i = 1; i < str.length(); i++)
        {
            if(str.charAt(i) == str.charAt(i-1))
            {
                cnt++;
            }
            else{
                result += str.charAt(i-1) + String.valueOf(cnt);
                cnt = 1;
            }
        }
        result += str.charAt(str.length() - 1) + String.valueOf(cnt);
        System.out.println(result);
    }
}
