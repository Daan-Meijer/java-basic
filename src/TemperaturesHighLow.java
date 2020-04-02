import java.util.Arrays;
import java.util.Scanner;

// This program asks the user for the lowest and highest temperatures for each month of the year and returns these numbers in separate lists.

public class TemperaturesHighLow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        double[] lowTemps = new double[12];
        double[] highTemps = new double[12];

        for (int i=0; i<12; i++){
            System.out.println("What was the lowest temperature in " + months[i] + "? ");
            lowTemps[i] = scanner.nextDouble();
            System.out.println("What was the highest temperature in " + months[i] + "? ");
            highTemps[i] = scanner.nextDouble();
        }

        System.out.println("Lowest temperatures: " + Arrays.toString(lowTemps));
        System.out.println("Highest temperatures: " + Arrays.toString(highTemps));
    }
}
