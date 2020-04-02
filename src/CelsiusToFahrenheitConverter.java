import java.util.Scanner;

// This program converts celsius to fahrenheit.

public class CelsiusToFahrenheitConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the temperature in degrees Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = 1.8*celsius + 32;

        System.out.println("The temperature in Fahrenheit is " + fahrenheit + "°.");
    }
}
