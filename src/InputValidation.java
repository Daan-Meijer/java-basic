import java.util.Scanner;

public class InputValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = 0;
        while(input < 1 || input > 10){
            System.out.println("Please enter a number between 1 and 10: ");
            input = scanner.nextDouble();
        }
        System.out.println("Thank you");
    }
}
