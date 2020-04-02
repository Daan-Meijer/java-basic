import java.util.Scanner;

// This program calculates the number of occurrences of the letter "a" in a given word.

public class OccurrenceOfLetterA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a word: ");
        char[] word = scanner.nextLine().toCharArray();

        int counter = 0;
        for (char c : word) {
            if (c == 'a'){
                counter += 1;
            }
        }

        System.out.println("The letter a occurs " + counter + " times.");
    }
}
