import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String a = "Have a nice TUESDAY";
        String b = "Have a NICE tuesday";

//        boolean comparison = a.equals(b);
        boolean comparison = a.equalsIgnoreCase(b);
//        System.out.println(comparison);

        String c = "CE tuesd";
        boolean contains = a.toUpperCase().contains(c.toUpperCase());
        System.out.println(contains);
        System.out.println(a);

        String name = "Augustas";
        String text = "Hello, " + name + ". Have a good day";
        String f = "Hello, %s. Have a good day".formatted(name);
        String replaced = f.replace("day", "evening");
        System.out.println(replaced);


        String[] words = a.split(" ");
        System.out.println(Arrays.asList(words));

        String subtext = text.substring(2, 10);
        System.out.println(subtext);

        String no = " LT123432  ";
        if(no.trim().equals("LT123432")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }

        System.out.println(
                no.trim().equals("LT123432") ? "Access granted" : "Access denied");









//        int skaicius = 15;
//        String tekstas = "Hello, Augustas";
//        boolean arSiandienLyja = false;


//        Scanner s = new Scanner(System.in);
//
//        while(true) {
//
//            System.out.println("Enter a number, operation, and number again:");
//            double a = s.nextDouble();
//            String operation = s.next();
//            double b = s.nextDouble();
//
//            switch (operation) {
//                case "+" -> System.out.println(a + b);
//                case "-" -> System.out.println(a - b);
//                case "*" -> System.out.println(a * b);
//                case "/" -> System.out.println(a / b);
//                default -> System.err.println("Invalid operation. Select from: + - * /");
//            }
//        }

    }
}