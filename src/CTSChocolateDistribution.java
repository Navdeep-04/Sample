public class CTSChocolateDistribution {
    public static void main(String[] args) {
        int n = 6;
        int sum = 0;
        for(int i = 1; i <= n; i++)
        {
            if(n % 5 == 0 && i == 1)
            {
                sum += i + 2;
            }
            else if((i + 1) <= n && (i + 1) % 5==0 || (i > 1 && (i - 1) % 5 == 0))
            {
                sum += i + 2;
            }
            else{
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
