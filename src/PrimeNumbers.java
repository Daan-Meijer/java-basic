import java.util.ArrayList;

public class PrimeNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> primeNumberList = new ArrayList<>();
        primeNumberList.add(1);
        int n = 1;

        while(primeNumberList.size() < 10){
            ArrayList<Integer> myDividers = divisors(n);

            // Call divisors method. If the number of divisors is 2, the number is a prime number.
            if (myDividers.size() == 2){
                primeNumberList.add(n);
            }
            n++;
        }

        System.out.println(primeNumberList.toString());
    }

    // Method to determine the divisors for a given number

    static ArrayList<Integer> divisors(int number){
        ArrayList<Integer> divisorList = new ArrayList<>();
        for (int m=0; m<number; m++){
            if (number%(m+1) == 0){
                divisorList.add(m);
            }
        }
        return divisorList;
    }
}
