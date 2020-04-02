import java.util.Scanner;

// This program tells the user which scores from a list of 5 are higher than a 7.

public class TestScoreComparer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter five test scores (e.g. 1, 2, 3, 4, 5: ");
        String[] scores = scanner.nextLine().split(", ");

        int count = 0;
        for(int i=0; i<5; i++){
            if (Double.parseDouble(scores[i]) > 7){
                count += 1;
            }
        }
        System.out.println(count + " scores are higher than a 7.");
    }
}
