//import java.util.*;
//public class MathSqrt
//{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n = 4;
//        int max = 0;
//        for(int i = 1; i <= n/2; i++){
//            int value = i*i;
//            if(value <= n){
//                max=i;
//            }
//        }
//        System.out.print(max);
//    }
//}

import java.util.*;
public class MathSqrt
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int i = 0;
        if(num <= 0)
        {
            System.out.println(num);
        }
        while(i * i <= num)
        {
            i++;
        }
        i--;
        System.out.println(i);
    }
}