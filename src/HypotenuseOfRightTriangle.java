import java.util.Scanner;
import java.lang.Math;

// This program calculates the hypotenuse of a right triangle for two given right sides.

public class HypotenuseOfRightTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the first right side: ");
        double firstSide = scanner.nextDouble();

        System.out.println("Enter the length of the second right side: ");
        double secondSide = scanner.nextDouble();

        double hypotenuse = Math.sqrt(Math.pow(firstSide, 2) + Math.pow(secondSide, 2));

        System.out.println("The length of the hypotenuse is: " + hypotenuse + ".");
    }
}
