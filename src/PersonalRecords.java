import java.util.Scanner;

// This program allows the user to look up the birthday and phone number for an existing name in an array.

public class PersonalRecords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = {"Henk", "Piet", "Jantje"};
        String[] birthdays = {"01-04-1990", "11-11-2011", "06-06-2006"};
        String[] phoneNumbers = {"06-14141414", "06-11111111", "06-66666666"};

        System.out.println("Who would you like to look up? ");
        String nameUI = scanner.nextLine();

        int myIndex;
        for (int i=0; i<names.length; i++){
            if (nameUI.equals(names[i])){
                myIndex = i;
                System.out.println("Birthday: " + birthdays[myIndex] + ". Phone number: " + phoneNumbers[myIndex]);
            }
        }
    }
}
