public class ReverseVowelsOfString {
    public static void main(String[] args) {
        String str = "IceCreAm";
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length-1;
        while(start < end)
        {
            if(!(arr[start] == 'A' || arr[start] == 'a' || arr[start] == 'E' || arr[start] == 'e'
                    || arr[start] == 'I' || arr[start] == 'i' || arr[start] == 'O' || arr[start] == 'o'
                    || arr[start] == 'U' || arr[start] == 'u'))
            {
                start++;
            }
            if(!(arr[end] == 'A' || arr[end] == 'a' || arr[end] == 'E' || arr[end] == 'e'
                    || arr[end] == 'I' || arr[end] == 'i' || arr[end] == 'O' || arr[end] == 'o'
                    || arr[end] == 'U' || arr[end] == 'u'))
            {
                end--;
            }
            if(start<end) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            start++;
            end--;
        }
        System.out.println(new String(arr));
    }
}
