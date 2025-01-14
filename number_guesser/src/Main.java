import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 1. sugeneruoti random skaičių
        Scanner s = new Scanner(System.in);
        int rand = (int) (Math.random() * 100) + 1;
        int guess = 0;
        int maxAttempts = 0;

        System.out.println("Set a guess limit for yourself:");
        // sukurti kintamaji, paimti reiksme is konsoles
        int limit = s.nextInt();

        // 2. pradėti ciklą
        System.out.println("Guess a number 1-100:");
        while(guess != rand) {
            // patikrinti ar liko spejimu
            if(maxAttempts == limit) {
                System.err.println("Out of guesses!");
                return;
            }

            // patikrinti ar likusiu spejimu skaicius yra trys arba maziau
            // jei taip, pranesam kiek liko spejimu
            if(limit - maxAttempts <= 3) {
                System.out.println("Only " + (limit - maxAttempts) + " guess(es) left");
            }

            // perskaityti naudotojo spėjimą - nextInt()
            guess = s.nextInt();

            // palyginti spėjimą su random skaičiumi
            // neatspėjo, pasakom atsakymas didesnis ar mažesnis
            if(guess > rand) {
                System.out.println("Guess less");
            } else if(guess < rand) {
                System.out.println("Guess more");
            }

//            guessCount = guessCount + 1;
//            guessCount += 1;
            maxAttempts++;
        }

        System.out.println("Congratulations!");
    }
}