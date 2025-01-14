import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        int skaicius = 15;
//        String tekstas = "Hello, Augustas";
//        boolean arSiandienLyja = false;


        Scanner s = new Scanner(System.in);

        while(true) {

            System.out.println("Enter a number, operation, and number again:");
            double a = s.nextDouble();
            String operation = s.next();
            double b = s.nextDouble();

            switch (operation) {
                case "+" -> System.out.println(a + b);
                case "-" -> System.out.println(a - b);
                case "*" -> System.out.println(a * b);
                case "/" -> System.out.println(a / b);
                default -> System.err.println("Invalid operation. Select from: + - * /");
            }
        }

    }
}