// This program calculates the sum of all odd integers between one and twenty.

public class SumOfOddsOneToTwenty {
    public static void main(String[] args) {
        int[] myList = new int[20];

        int sum = 0;
        for(int i=0; i<20; i++){
            myList[i] = i+1;
            if(myList[i] % 2 == 1) {
                sum += myList[i];
            }
        }

        System.out.println("The sum of all odd numbers from one to twenty is " + sum);
    }
}
