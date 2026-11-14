
class FindFreqCanBeEqual{
    public static void main(String[] args)
    {
        String str = "xyyz";
        int[] freq = new int[26];
        int max = 0;
        int sum = 0;
        for(int i = 0; i < str.length(); i++)
        {
            freq[str.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++)
        {
            if(freq[i] != 0) {
                max = max ^ freq[i];
            }
        }
        boolean check = false;
        sum = max - 1;
        if(sum != 0) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] != 0 && freq[i] == sum) {
                    check = true;
                }
            }
            System.out.println(check);
        }
        else{
            System.out.println(true);
        }
    }
}