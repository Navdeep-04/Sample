public class Pattern1 {
    public static void main(String[] args) {
        int n = 5;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(j>i)
                {
                    System.out.print("  ");
                }
                else
                {
                    System.out.print(i+" ");
                }
            }
            for(int k = 1; k <= n; k++)
            {
                if(k < n-i+1)
                {
                    System.out.print("  ");
                }
                else
                {
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }
    }
}
