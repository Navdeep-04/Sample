import java.util.*;
public class SqrtMath
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        double sqrt = 0;
        for(int i = 1; i*i <= num; i++)
        {
            sqrt = i;
        }
        System.out.println(sqrt);
        double k = 0.0;
        for(double i = 0.1; i >= 0.001; i = i/10)
        {
            for(double j = i; (sqrt+j)*(sqrt+j) <= num; j = j+i)
            {
                k = j;
            }
            sqrt = sqrt + k;
        }
        System.out.printf("%.3f",sqrt);
    }
}