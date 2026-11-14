public class FindUniqueCharCount {
    public static void main(String[] args) {
        String str = "abbccc";
        int[] arr = new int[26];
        boolean result = true;
        for(int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        a: for(int i = 0; i < arr.length; i++)
        {
            for(int j = i+1; j < arr.length; j++)
            {
                if(arr[i] == arr[j] && arr[i] != 0)
                {
                    result = false;
                    break a;
                }
            }
        }
        if(result)
        {
            System.out.println("Unique.");
        }
        else{
            System.out.println("Not unique.");
        }
    }
}
