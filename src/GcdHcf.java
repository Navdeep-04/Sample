public class GcdHcf {
//    public static void main(String[] args) {
//        int num1 = 36, num2 = 72;
//        int hcf = 1;
//
//        for (int i = 1; i <= num1 && i <= num2; i++) {
//            if (num1 % i == 0 && num2 % i == 0) {
//                hcf = i;
//            }
//        }
//        System.out.println("The HCF of two numbers is: " + hcf);
//    }
//}

//Method 2
//
//
//public class Main {
    public static void main(String[] args) {
        int num1 = 36, num2 = 60;

        while (num1 != num2) {
            if (num1 > num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
        }

        System.out.println("The HCF of two numbers is: " + num1);
    }
}
