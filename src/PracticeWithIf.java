import java.util.Scanner;

// Just some practice with if statements.

public class PracticeWithIf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a value for x: ");
        int x = scanner.nextInt();

        System.out.println("Please enter a value for y: ");
        int y = scanner.nextInt();

        if (x/y == 5) x = 100;
        if (x*y == 5) x = 1;
        if (x<y) x *= 2;
        if (x>y) x++;

        System.out.println("The new value of x is: " + x);
    }
}
