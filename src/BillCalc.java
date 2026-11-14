import java.util.Scanner;
class BillCalc
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double unit = sc.nextDouble();
        Double bill = 0.0;
        if(unit <= 50)
        {
            bill = (unit * 3.5);
        }
        else if(unit <=150)
        {
            bill = (unit - 50) * 4.5 + (50 * 3.5);
        }
        else if(unit <= 250)
        {
            bill = (unit - 150) * 5.2 + (100 * 4.5) + (50 * 3.5);
        }
        else
        {
            bill = (unit - 250) * 6.75 + (100 * 5.2) + (100 * 4.5) + (50 * 3.5);
        }
        double AdditionalCharge = (bill * 20/100);
        System.out.println((bill*20/100)+bill);
    }
}