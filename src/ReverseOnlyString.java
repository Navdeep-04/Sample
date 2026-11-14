public class ReverseOnlyString {
    public static void main(String[] args) {
        String s = "ab-cd";
        int start = 0;
        int end = s.length()-1;
        char[] arr = s.toCharArray();
        while(start < end) {
            while(start < end && !((s.charAt(start) >= 'a' && s.charAt(start) <= 'z') || (s.charAt(start) >= 'A' && s.charAt(start) <= 'Z')))
            {
                start++;
            }
            while(start < end && !((s.charAt(end) >= 'a' && s.charAt(end) <= 'z') || (s.charAt(end) >= 'A' && s.charAt(end) <= 'Z')))
            {
                end--;
            }
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        System.out.println(new String(arr));
    }
}
