import java.util.Scanner;

// This program asks for an article, a noun and a verb and builds them into a sentence.

public class SentenceBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an article (An, A, The): ");
        String article = scanner.nextLine();

        System.out.print("Enter a noun: ");
        String noun = scanner.nextLine();

        System.out.print("Enter a verb: ");
        String verb = scanner.nextLine();

        System.out.println(article + " " + noun + " " + verb + ".");
    }
}
