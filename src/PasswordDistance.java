public class PasswordDistance {
    public static void main(String[] args) {
        String str = "bbbbabb";
        int max = 0;
        for(int i = 0; i < str.length(); i++)
        {
            int cnt = 0;
            for(int j = i+1; j < str.length(); j++) {
                if (str.charAt(i) != str.charAt(j)) {
                    cnt++;

                }
            }
            if(cnt > max)
            {
                max = cnt;
            }
        }
        System.out.println(max);
    }
}
