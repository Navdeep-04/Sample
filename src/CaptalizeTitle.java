import java.util.Arrays;

public class CaptalizeTitle {
    public static void main(String[] args) {
        String title = "capiTalIze the titLe";
        String[] arr = title.split(" ");
        for(int i = 0; i < arr.length; i++)
        {
            String n = arr[i];
            String str = "";
            for(int j = 0; j < n.length(); j++)
            {
                if(j == 0 && n.length() > 2)
                {
                    str += Character.toUpperCase(n.charAt(j));
                }
                else
                {
                    str += Character.toLowerCase(n.charAt(j));
                }
            }
            arr[i] = str;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(String.join(" ",arr));
    }
}
