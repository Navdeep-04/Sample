
class AADemo{
    public static void main(String[] args) {
        int n = 5;
        int m = n * 2;
        int  l = 4;
        int p = 4;
        int k = 0;
        for (int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= i; j++)
            {
                if(i == j)
                {
                    k = m + i;
                    System.out.print(k+" ");
                    k -= l;
                    l += l;
                }
                else{
                    System.out.print(k+" ");
                    k += p + i;
                }

            }
            System.out.println();
        }
    }
}