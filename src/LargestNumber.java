import java.util.Scanner;

// This program determines the largest number out of three numbers.

public class LargestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter three numbers (e.g. 1, 3.14, 5000): ");
        String[] numbers = scanner.nextLine().split(", ");

        double highest = Double.parseDouble(numbers[0]);
        for(int i=0; i<3; i++){
            if (Double.parseDouble(numbers[i]) > highest){
                highest = Double.parseDouble(numbers[i]);
            }
        }

        System.out.println("Your highest number is " + highest + ".");
    }
}
