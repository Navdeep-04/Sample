import java.util.Arrays;

public class Transpose {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] srr = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                srr[i][j] = arr[j][i];
            }
        }
        for (int i = 0; i < srr.length; i++) {
            for (int j = 0; j < srr[0].length; j++) {
                System.out.print(srr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int temp = srr[i][left];
                srr[i][left] = srr[i][right];
                srr[i][right] = temp;
                left++;
                right--;
            }
        }
        for (int i = 0; i < srr.length; i++) {
            for (int j = 0; j < srr[0].length; j++) {
                System.out.print(srr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
