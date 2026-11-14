public class SquareRoot {
    public static void main(String[] args) {
        int n = 2;
        double square = n/2;
        double t = square;
        do{
            t = square;
            square = (t + (n/t))/2;
        }
        while((t-square)!=0);
        System.out.println(square);
    }
}
