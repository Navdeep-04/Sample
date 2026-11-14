public class Isogram {
    public static void main(String[] args) {
        String str = "navdeep";
        int[] arr = new int[26];
        //
        for(int i = 0; i < str.length(); i++)
        {
            arr[str.charAt(i) - 'a']++;
        }
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > 1){
                System.out.println("Not Isogram");
                return;
            }
        }
        System.out.println("Isogram");
    }
}
