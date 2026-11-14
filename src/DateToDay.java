import java.util.Scanner;

public class DateToDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] Date = str.split("/");
        int date = Integer.parseInt(Date[0]);
        int month = Integer.parseInt(Date[1]);
        int year = Integer.parseInt(Date[2]);
        int yearCode = 0;
        int yearLastTwo = year % 100;
        int yearByFour = yearLastTwo / 4;
        int[] monthCode = {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
        String[] Day = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
        if (year >= 2000 && year <= 2099) {
            yearCode = 6;
        }
        int ToDay = date + monthCode[month - 1] + yearCode + yearLastTwo + yearByFour;
        int dayCode = ToDay % 7;
        System.out.println(Day[dayCode]);
    }
}
