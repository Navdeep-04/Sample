import java.util.Scanner;

public class Discount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        int tickets = sc.nextInt();
        double amount = price*tickets;
        double discount = 0;
        if(tickets < 50)
        {
            discount = amount * 0;
        }
        else if(tickets <= 100)
        {
            discount = amount * 10/100;
        }
        else if(tickets <= 200 )
        {
            discount = amount * 20/100;
        }
        else if(tickets <= 400)
        {
            discount = amount * 30/100;
        }
        else if(tickets <= 500)
        {
            discount = amount * 40/100;
        }
        else
        {
            discount = amount * 50/100;
        }

        System.out.print(amount - discount);
    }
}
