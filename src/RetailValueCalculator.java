import java.util.Scanner;

// This program calculates the retail value based on the type of product and quantity of product sold at set prices.

public class RetailValueCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your product number: ");
        int productNumber = scanner.nextInt();

        System.out.println("Please enter the quantity of product number " + productNumber + " sold.");
        int quantitySold = scanner.nextInt();

        double retailValue;
        switch(productNumber){
            case 1:
                retailValue = quantitySold * 2.95;
                break;
            case 2:
                retailValue = quantitySold * 4.99;
                break;
            case 3:
                retailValue = quantitySold * 5.49;
                break;
            case 4:
                retailValue = quantitySold * 7.80;
                break;
            case 5:
                retailValue = quantitySold * 8.85;
                break;
            default:
                throw new IllegalArgumentException("invalid product number!");
        }

        System.out.println("Your retail value is: " + retailValue);
    }
}
