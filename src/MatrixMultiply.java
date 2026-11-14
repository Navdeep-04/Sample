import java.util.Arrays;

public class MatrixMultiply {
    public static void main(String[] args) {
        int[][] arr = {{1,2},
                       {3,4}};
        int[][] brr = {{4,3},
                       {2,1}};
        int[][] mrr = new int[2][2];
        for(int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                int a = 0;
                for (int k = 0; k < brr[i].length; k++)
                {
                    a += arr[i][k] * brr[k][j];
                }
                mrr[i][j] = a;
            }
        }
        for(int[] m : mrr) {
            System.out.println(Arrays.toString(m));
        }
    }
}

//[a11 a12]  [b11 b12]        [(a11b11 + a12b21)   (a11b12 + a12b22)]
//[a21 a22]  [b21 b22]        [(a21b11 + a22b21)   (a21b12 + a22b22)]