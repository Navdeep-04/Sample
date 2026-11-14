public class StringConvWithoutMethods {
    public static void main(String[] args) {
        String str = "AbCd";
        for(int i = 0; i < str.length(); i++){
            System.out.print((char) (str.charAt(i)^32));
        }
    }
}
// A = 1100001
// 32 = 100000
// a = 1000001