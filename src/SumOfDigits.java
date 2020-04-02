import java.util.Scanner;

// This program calculates the sum of the digits of a given positive integer.

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a positive integer: ");
        String[] digits = scanner.nextLine().split("");

        int sumOfDigits = 0;
        for (String digit : digits){
            sumOfDigits += Integer.parseInt(digit);
        }

        System.out.println("The sum of digits is: " + sumOfDigits);
    }
}
