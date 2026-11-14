import java.util.Scanner;

public class TwoDarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                arr[row][col] = sc.nextInt();
            }
        }
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            int rsum = 0;
            int csum = 0;
            for (int j = 0; j < m; j++) {
                rsum += arr[i][j];
                csum += arr[j][i];
            }
            System.out.println("Sum of the row : " + rsum);
            System.out.println("Sum of the col : " + csum);
            for(int x = 0; x < n; x++)
            {
                a[x] = rsum;
                b[x] = csum;
            }
        }
        int rmax = 0;
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] > rmax)
            {
                rmax = a[i];
            }
        }
        int cmax = 0;
        for(int i = 0; i < b.length; i++)
        {
            if(b[i] > cmax)
            {
                cmax = b[i];
            }
        }
        if(rmax > cmax )
        {
            System.out.println("Maximum num : "+rmax);
        }
        else{
            System.out.println("Maximum num : "+cmax);
        }
    }
}


//import java.util.*;
//public class Main
//{
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int rsize = scan.nextInt();
//        int csize = scan.nextInt();
//        int arr[][] = new int [rsize][csize];
//        for(int i=0;i<rsize;i++){
//            for(int j=0;j<csize;j++){
//                arr[i][j]=scan.nextInt();
//            }
//        }
//        int max = Integer.MIN_VALUE;
//        int row[]=new int[rsize];
//        int col [] = new int[csize];
//        for(int i=0;i<rsize;i++){
//            for(int j=0;j<csize;j++){
//                row[i]=row[i]+arr[i][j];
//                col[i]=col[i]+arr[j][i];
//            }
//            if(row[i]>max){
//                max=row[i];
//            }
//            if(col[i]>max){
//                max=col[i];
//            }
//        }
//        System.out.println(max);
//        for(int i=0;i<rsize;i++){
//            System.out.println("The sum of row"+i+" "+row[i]);
//        }
//        for(int i=0;i<csize;i++){
//            System.out.println("The sum of col"+i+" "+col[i]);
//        }
//    }
//}