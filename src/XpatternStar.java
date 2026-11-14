import java.util.Scanner;

public class XpatternStar {
        public static void main(String[] var0) {
            Scanner var1 = new Scanner(System.in);
            int var2 = var1.nextInt();

            for(int var3 = 0; var3 < var2; ++var3) {
                for(int var4 = 0; var4 < var2; ++var4) {
                    if (var3 != var4 && var4 != var2 - 1 - var3) {
                        System.out.print(" ");
                    } else {
                        System.out.print("* ");
                    }
                }

                System.out.println();
            }

        }
}
